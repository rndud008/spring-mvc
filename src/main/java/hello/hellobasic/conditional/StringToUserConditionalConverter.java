package hello.hellobasic.conditional;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConditionalConverter implements Converter<String, User>, ConditionalConverter {


    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        // 타겟 필드에 @CustomAnnotation이 있는지 확인
        return targetType.getType().isAssignableFrom(User.class);
    }

    @Override
    public User convert(String source) {
        User target = new User();
        target.setName(source);
        return target;
    }
}
