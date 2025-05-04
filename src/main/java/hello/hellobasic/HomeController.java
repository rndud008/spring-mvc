package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public User user(User user) {
        return user;
    }

    @GetMapping("/product")
    public Product product(Product product) {
        return product;
    }
}