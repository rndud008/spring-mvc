package hello.hellobasic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@Configuration
class WebConfig {

    @Bean
    public ViewResolver customViewResolver() {

        return new ViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                if ("customView".equals(viewName)) {
                    return new CustomView();
                }
                return null;
            }
        };
    }
}
