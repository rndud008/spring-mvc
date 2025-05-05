package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class ResponseBodyController {

    @GetMapping("/users/{name}")
    @ResponseBody
    public User getUser1(@PathVariable("name") String name){

        return new User(name, 10);
    }
}
