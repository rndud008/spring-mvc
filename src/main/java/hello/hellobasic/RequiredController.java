package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequiredController {

    @GetMapping("/requiredTrue")
    public String requiredTrue(@RequestParam(name = "username", required = true) String username) {
        return "Hello, " + username;
    }

    @GetMapping("/requiredFalse")
    public String requiredFalse(@RequestParam(name = "username", required = false) String username) {
        return "Hello, " + username;
    }

    @GetMapping("/defaultValue")
    public String defaultValue(@RequestParam(name = "username", defaultValue = "기본값") String username) {
        return "Hello, " + username;
    }

}