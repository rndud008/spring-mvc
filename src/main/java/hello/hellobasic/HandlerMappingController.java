package hello.hellobasic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerMappingController {
    @GetMapping("/request")
    public String handleRequest(){
        return "HandlerMappingController";
    }
}
