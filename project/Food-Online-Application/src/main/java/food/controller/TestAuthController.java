package food.controller;

import food.config.jwt.AuthenticationResponse;
import food.config.jwt.JwtTokenProvider;
import food.domain.User;
import food.service.CustomUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin
public class TestAuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserService userService;

    @GetMapping("/api/auth/test")
    public ResponseEntity<?> test(HttpServletRequest request) {
        System.out.println("=== Test Auth Controller ===");
        String token = jwtTokenProvider.resolveToken(request);
        User user = userService.getUserByToken(token);

        if (user == null) {
            // Invalid token, redirect to error page or handle appropriately
            System.out.println("User is Null in TestAuth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
//            return new ModelAndView("login"); // Specify the name of the error page
        }

        return ResponseEntity.ok(new AuthenticationResponse(token));
//        // Valid token, redirect to testAuth page
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("testAuth"); // Specify the name of your testAuth page
////        modelAndView.addObject("user", user); // You can pass user information to the view if needed
//        return modelAndView;
    }

    @GetMapping("/testAuth")
    public ModelAndView getTestAuthPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testAuth"); // Set the name of your Thymeleaf template (login.html)
        return modelAndView;
    }
}
