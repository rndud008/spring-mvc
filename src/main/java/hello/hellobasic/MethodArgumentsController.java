package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodArgumentsController {
    @GetMapping("/request")
    public User request(@RequestParam("name") String name, @RequestParam("age") int age, User user) { // Model 인자를 전달하는 HandlerMethodArgumentResolver 작동, String 반환타입을 처리하는 HandlerMethodReturnValueHandler 작동
        return user;
    }
}