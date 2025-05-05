package hello.hellobasic;

import hello.hellobasic.conditional.User;
import hello.hellobasic.converter.Url;
import hello.hellobasic.factory.OrderColor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SpringConverterController {

    @PostMapping("/url")
    public String saveUrl(@ModelAttribute("url") Url url) {
        return "url: " + url;
    }

    @PostMapping("/users")
    public User user(@RequestParam("user") User user) {
        return user;
    }

    @GetMapping("/color")
    public OrderColor color(@RequestParam("color") OrderColor color) {  // 컨버터가 존재하지 않으면 타입변환이 실패하여 오류 발생
        return color;
    }
}