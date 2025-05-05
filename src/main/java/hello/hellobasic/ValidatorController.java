package hello.hellobasic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class ValidatorController {

    @Autowired
    private UserValidator validator;

    @Autowired
    private List<Validator> validators;

   @PostMapping("/users1")
    @ResponseBody
    public String users1(@ModelAttribute User user, BindingResult result) {


        validator.validate(user, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "error: " + result.getAllErrors();
        }
        return "success: " + user;
    }


    @PostMapping("/users2")
    @ResponseBody
    public String users2(@ModelAttribute User user, BindingResult result) {

        for (Validator validator : validators) {
            if(validator.supports(result.getTarget().getClass())){
                validator.validate(result.getTarget(), result);
            }
        }
//        validator.validate(admin, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "error: " + result.getAllErrors();
        }
        return "success: " + user;
    }

}