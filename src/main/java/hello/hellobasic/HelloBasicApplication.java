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



}
