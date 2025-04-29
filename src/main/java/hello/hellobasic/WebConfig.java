package hello.hellobasic;

import hello.hellobasic.converter.IntegerToStringConverter;
import hello.hellobasic.converter.IpPortToStringConverter;
import hello.hellobasic.converter.StringToIntegerConverter;
import hello.hellobasic.converter.StringToIpPortConvert;
import hello.hellobasic.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 컨버터가 포맷터보다 우선순위가 높기 때문에 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());

        registry.addConverter(new StringToIpPortConvert());
        registry.addConverter(new IpPortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
