package hello.hellobasic;


import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class CustomFormatterRegistrar implements FormatterRegistrar {
    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatter(new KoreanCurrencyFormatter());
        registry.addConverter(new StringToUrlConverter());
    }
}