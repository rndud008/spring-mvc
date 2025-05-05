package hello.hellobasic;


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

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        DefaultMessageCodesResolver resolver = new DefaultMessageCodesResolver();
        String[] objectErrorCodes = resolver.resolveMessageCodes("required","user");
        Arrays.stream(objectErrorCodes).forEach(System.out::println);
        System.out.println("objectErrorCodes = " + objectErrorCodes);

        String[] filedErrorCodes = resolver.resolveMessageCodes("required","user","age",Integer.class);
        Arrays.stream(filedErrorCodes).forEach(System.out::println);
        System.out.println("filedErrorCodes = " + filedErrorCodes);

        
        
    }







}
