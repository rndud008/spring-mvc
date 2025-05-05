package hello.hellobasic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class ValidatorInitBinderController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AdminValidator adminValidator;

    @InitBinder("user")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @InitBinder("admin")
    public void initBinder2(WebDataBinder binder) {
        binder.addValidators(adminValidator);
    }

    @PostMapping("/users3")
    @ResponseBody
    public String users3(@Validated @ModelAttribute("user") User user, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "error: " + result.getAllErrors();
        }
        return "success: " + user;
    }

    @PostMapping("/users4")
    @ResponseBody
    public String users4(@Validated @ModelAttribute("admin") Admin admin, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "error: " + result.getAllErrors();
        }
        return "success: " + admin;
    }

}
