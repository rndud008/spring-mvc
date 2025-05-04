package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NamedController {

    @GetMapping("/noNamed")
    public String noNamed(@RequestParam String username) {
        return "Hello, " + username;
    }

    @GetMapping("/noRequestParam")
    public String noRequestParam(String username) {
        return "Hello, " + username;
    }

}