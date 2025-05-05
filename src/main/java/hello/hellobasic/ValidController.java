package hello.hellobasic;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ValidController {

    @PostMapping("/users1")
    @ResponseBody
    public String createUser1(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error("error : {} ", error.getDefaultMessage()));
            return "error: " + bindingResult.getAllErrors();
        }

        return "success: " + user;
    }

    @PostMapping("/users2")
    @ResponseBody
    public String createUser2(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error("error : {} ", error.getDefaultMessage()));
            return "error: " + bindingResult.getAllErrors();
        }

        return "success: " + user;
    }

}
