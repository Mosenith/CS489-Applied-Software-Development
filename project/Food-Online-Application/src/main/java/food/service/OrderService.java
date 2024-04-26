package food.service;

import food.domain.Order;
import food.repository.OrderRepository;
import food.service.dto.OrderAdapter;
import food.service.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    public Order createOrder(Order order) {
        orderRepo.save(order);
        return order;
    }

    public Order getOrderById(Long orderID) {
        return orderRepo.findOrderByOrderId(orderID);
    }

    public List<OrderDto> getAllOrders() {
        List<OrderDto> orders = new ArrayList<>();

        for(Order order : orderRepo.findAll()) {
            orders.add(OrderAdapter.getOrderDtoFromOrder(order));
        }

        return orders;
    }
}
