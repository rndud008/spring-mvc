package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerAdviceController {

    @GetMapping("/exception2")
    public String exception2() {
        throw new IllegalArgumentException("IllegalArgumentException");
    }
}
