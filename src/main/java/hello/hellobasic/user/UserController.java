package hello.hellobasic.user;

import hello.hellobasic.exception.CustomNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<User> getUsers() {
        throw new CustomNotFoundException("User not found");
    }
}