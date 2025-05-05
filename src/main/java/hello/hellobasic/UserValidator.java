package hello.hellobasic;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "사용자명은 필수입니다.");

        if(user.getAge() > 100){
            errors.rejectValue("age", "max", new Object[]{100}, "나이가 너무 많습니다.");
        }

        //글로벌 오류
        if("admin".equals(user.getUsername()) && user.getAge() < 10){
            errors.reject("authority");
        }
    }
}