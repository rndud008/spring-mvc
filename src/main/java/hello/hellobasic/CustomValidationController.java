package hello.hellobasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class CustomValidationController {

    @PostMapping("/user")
    @ResponseBody
    public String registerUser(@Validated @ModelAttribute("user") User user, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "error: " + result.getAllErrors();
        }
        return "success: " + user;
    }

}