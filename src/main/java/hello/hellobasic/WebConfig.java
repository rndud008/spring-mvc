package hello.hellobasic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(simpleMappingExceptionResolver());
    }
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties exceptionMappings = new Properties(); // 예외와 뷰 매핑
        exceptionMappings.put("java.lang.ArithmeticException", "errorArithmetic"); // 예외는 전체 이름을 적는다
        exceptionMappings.put("java.lang.NullPointerException", "errorNullPointer");
        resolver.setExceptionMappings(exceptionMappings);

        resolver.setDefaultErrorView("errorDefault"); // 기본 오류 뷰, 발생한 예외에 맞는 뷰가 없을 경우

        Properties statusCodes = new Properties(); // 뷰 이름과 HTTP 상태 코드 매핑
        statusCodes.put("errorArithmetic", "404");
        statusCodes.put("errorNullPointer", "500");
        resolver.setStatusCodes(statusCodes);

        return resolver;
    }

}
