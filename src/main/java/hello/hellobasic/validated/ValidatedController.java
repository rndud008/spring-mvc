package hello.hellobasic.validated;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ValidatedController {

    @PostMapping("/createUser")
    @ResponseBody
    public String createUser(@Validated(VGroups.CreateGroup.class) @ModelAttribute Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error("error : {} ", error.getDefaultMessage()));
            return "error: " + bindingResult.getAllErrors();
        }

        return "success: " + user;
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUser(@Validated({VGroups.UpdateGroup.class}) @ModelAttribute Users user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> log.error("error : {} ", error.getDefaultMessage()));
            return "error: " + bindingResult.getAllErrors();
        }

        return "success: " + user;
    }

}
