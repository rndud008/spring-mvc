package hello.hellobasic.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController2 {
    // 빈이름 중복으로 2로 생성

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}