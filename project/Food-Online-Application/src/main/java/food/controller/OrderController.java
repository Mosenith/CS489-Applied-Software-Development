package food.controller;

import food.domain.Order;
import food.domain.OrderHistory;
import food.repository.OrderHistoryRepository;
import food.repository.UserRepository;
import food.service.CustomUserService;
import food.service.OrderService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;

@Slf4j
@Controller
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;;
    @Autowired
    CustomUserService userService;
    @Autowired
    HttpSession httpSession; // Inject HttpSession

    @GetMapping("/orders/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/orders")
    public String processOrder(@Valid Order order, Errors errors) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        // Retrieve session attributes
        String checkedItems = (String) httpSession.getAttribute("checkedItems");
        Double totalPrice = (Double) httpSession.getAttribute("totalPrice");
        String token = (String) httpSession.getAttribute("token");

        OrderHistory history = new OrderHistory();
        history.setUserId(userService.getUserByToken(token).getId());
        history.setMenuNames(Arrays.asList(checkedItems.split(",")));
        history.setTotalPrice(totalPrice);
        orderHistoryRepository.save(history);

        log.info("Passed history: {}", history);
        log.info("Order Submitted: {}", order);
        orderService.createOrder(order);

        return "redirect:/";
    }

    @GetMapping("/test/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        Order searchOrder = orderService.getOrderById(orderId);
        if(searchOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchOrder, HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }
}
