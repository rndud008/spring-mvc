package hello.hellobasic;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AdminValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "관리자명은 필수입니다.");

        if(admin.getLevel() < 1){
            errors.rejectValue("level", "min", new Object[]{1}, "나이가 너무 많습니다.");
        }
    }
}
