package hello.hellobasic;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BindingResultController {

    @PostMapping("/users")
    @ResponseBody
    public User registerUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if(!StringUtils.hasText(user.getUsername())) {
            bindingResult.addError(new FieldError("user", "username", "사용자 이름은 필수입니다."));
        }

        if(!StringUtils.hasText(user.getUsername()) && user.getAge() < 1) {
            bindingResult.addError(new ObjectError("user",  "사용자 정보가 잘못 되었습니다."));
        }
        return user;
    }
}
