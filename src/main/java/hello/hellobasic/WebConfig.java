package hello.hellobasic;

import hello.hellobasic.advanced.LoggingInterceptor;
import hello.hellobasic.advanced.MyInterceptor;
import hello.hellobasic.basic.CustomInterceptor1;
import hello.hellobasic.basic.CustomInterceptor2;
import hello.hellobasic.multi.FirstInterceptor;
import hello.hellobasic.multi.SecondInterceptor;
import hello.hellobasic.multi.ThirdInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


    private final CustomInterceptor1 customInterceptor1;
    private final CustomInterceptor2 customInterceptor2;
    private final LoggingInterceptor loggingInterceptor;
    private final MyInterceptor myInterceptor;
    private final FirstInterceptor firstInterceptor;
    private final SecondInterceptor secondInterceptor;
    private final ThirdInterceptor thirdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(customInterceptor1)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public/**")
                .order(1);

        registry.addInterceptor(customInterceptor2)
                .addPathPatterns("/login/**")
                .order(2);

        registry.addInterceptor(loggingInterceptor).addPathPatterns("/log");
        registry.addInterceptor(myInterceptor).addPathPatterns("/profile", "/admin");
        registry.addInterceptor(firstInterceptor).order(3).addPathPatterns("/order");
        registry.addInterceptor(secondInterceptor).order(4).addPathPatterns("/order");
        registry.addInterceptor(thirdInterceptor).order(5).addPathPatterns("/order");
    }
}
