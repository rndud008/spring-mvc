package hello.hellobasic;

import hello.hellobasic.adapter.Adaptee;
import hello.hellobasic.adapter.Adapter;
import hello.hellobasic.adapter.Target;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@SpringBootApplication
public class HelloBasicApplication  implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(HelloBasicApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.newRequest(); // "Adaptee: Specific request called." 출력

    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties urlMappings = new Properties();
        urlMappings.setProperty("/simpleUrl", "myHttpRequestHandler");
        mapping.setMappings(urlMappings);
        mapping.setOrder(1);
        return mapping;
    }
    @Bean
    public MyHttpRequestHandler myHttpRequestHandler() {
        return new MyHttpRequestHandler();
    }

}
