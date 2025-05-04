package hello.hellobasic;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user(@RequestParam(name="username") String user, @RequestParam(name="age") int age) {
        return "Hello World";
    }
}
