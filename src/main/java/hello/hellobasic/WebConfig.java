package hello.hellobasic;

import hello.hellobasic.conditional.StringToUserConditionalConverter;
import hello.hellobasic.converter.StringToUrlConverter;
import hello.hellobasic.factory.StringToEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new StringToUrlConverter());
        registry.addConverter(new StringToUserConditionalConverter());
        registry.addConverterFactory(new StringToEnumConverterFactory());

    }
}
