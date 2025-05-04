package hello.hellobasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@SpringBootApplication
public class HelloBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBasicApplication.class, args);
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties urlMappings = new Properties();
        urlMappings.setProperty("/simpleUrl","myHttpRequestHandler");
        // simpleUrl 로 접근할경우 myHttpRequestHandler를 실행
        mapping.setMappings(urlMappings);
        mapping.setOrder(1);
        return mapping;
    }

    @Bean
    public MyHttpRequestHandler myHttpRequestHandler(){
        return new MyHttpRequestHandler();
    }

}
