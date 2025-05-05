package hello.hellobasic;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.Field;

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void contextLoads() {
//        StringToIntegerConverter converter = new StringToIntegerConverter();
//        Integer number = converter.convert("1");
//        Assertions.assertThat(number).isEqualTo(1);
    }


    @Test
    void converterFactory() {
//        // 1) 팩토리 생성
//        StringToEnumConverterFactory factory = new StringToEnumConverterFactory();
//
//        // 2) Color 변환기 얻기
//        Converter<String, OrderColor> colorConverter = factory.getConverter(OrderColor.class);
//        OrderColor color = colorConverter.convert("green");
//        System.out.println("Converted Color: " + color); // GREEN
//
//        // 3) Status 변환기 얻기
//        Converter<String, OrderStatus> statusConverter = factory.getConverter(OrderStatus.class);
//        OrderStatus status = statusConverter.convert("processing");
//        System.out.println("Converted Status: " + status); // SUSPENDED
//
//        // 4) 공백 or null → null
//        OrderColor nullColor = colorConverter.convert("  ");
//        System.out.println("Converted nullColor: " + nullColor); // null
//
//        // 5) 미존재 상수 -> IllegalArgumentException
//        try {
//            statusConverter.convert("UNKNOWN");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage()); // No enum constant ...
//        }
    }

    @Test
    void conditionalConverter() throws NoSuchFieldException {
//        // 필드의 TypeDescriptor 생성
//        Field field = User.class.getDeclaredField("name"); // User의 "name" 필드 가져오기
//        TypeDescriptor sourceType = TypeDescriptor.valueOf(Integer.class);  // 소스 타입
//        TypeDescriptor targetType = TypeDescriptor.nested(field, 0);       // 타겟 타입
//
//        // 변환기 생성
//        StringToUserConditionalConverter converter = new StringToUserConditionalConverter();
//
//        // matches() 검증 후 변환 수행
//        if (converter.matches(sourceType, targetType)) {
//            User target = converter.convert("test");
//            System.out.println("name: " + target.getName()); // 출력: name: test
//        } else {
//            System.out.println("Conversion not possible.");
//        }
    }

}
