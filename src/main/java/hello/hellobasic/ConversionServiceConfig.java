package hello.hellobasic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConversionServiceConfig {

    @Bean
    public DefaultConversionService conversionService() {

        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToUrlConverter());
        conversionService.addConverter(new UrlToStringConverter());
        return conversionService;

    }

}
