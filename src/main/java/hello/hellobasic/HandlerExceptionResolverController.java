package hello.hellobasic;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@Controller
public class HandlerExceptionResolverController {

    @GetMapping("/resource/{id}")
    public String resourceNotFound(@PathVariable("id") String id) {
        throw new ResourceNotFoundException(id);
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate(@RequestParam(required = false) String id) {
        if(!StringUtils.hasText(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id is required");
        }

        return "message: " + id;
    }


    @PostMapping("/post")
    public String testMethod() {
        return "POST Request";
    }

    @PostMapping(value = "/json", consumes = "application/json")
    public String consumeJson(@RequestBody String body) {
        return "body: " + body;
    }

    @GetMapping("/arithmeticError")
    public String arithmeticError() {
        throw new ArithmeticException("Arithmetic Exception Occurred!");
    }
    @GetMapping("/nullPointerError")
    public String nullPointerError() {
        throw new NullPointerException("Null Pointer Exception Occurred!");
    }

    @GetMapping("/defaultError")
    public String defaultError() {
        throw new RuntimeException("Runtime Exception Occurred!");
    }
}
