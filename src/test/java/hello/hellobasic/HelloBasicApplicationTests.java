package hello.hellobasic;


import jakarta.validation.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.DefaultMessageCodesResolver;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        User user = new User();
        user.setUsername("ab");
        user.setEmail("abcdefg");
        user.setAge(-1);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Assertions.assertThat(3).isEqualTo(violations.size());

        for (ConstraintViolation<User> violation : violations) {
            Path propertyPath = violation.getPropertyPath();
            String message = violation.getMessage();

            if(propertyPath.equals("username")){
                Assertions.assertThat("사용자명은 3~15 길이어야 합니다.").isEqualTo(message);
            }else if(propertyPath.equals("email")){
                Assertions.assertThat("이메일 형식이 맞지 않습니다.").isEqualTo(message);
            }else if(propertyPath.equals("age")){
                Assertions.assertThat("나이는 0 보다 커야 합니다.").isEqualTo(message);
            }
        }
        
        
    }







}
