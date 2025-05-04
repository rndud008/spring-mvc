package hello.hellobasic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerMappingController {
    @GetMapping("/request")
    public String request(String name, Model model, HttpServletRequest request, HttpServletResponse response) { // Model 인자를 전달하는 HandlerMethodArgumentResolver 작동, String 반환타입을 처리하는 HandlerMethodReturnValueHandler 작동
        return "home";
    }
}