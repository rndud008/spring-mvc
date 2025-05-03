package hello.hellobasic;

import hello.hellobasic.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.hellobasic.app")
public class HelloBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBasicApplication.class, args);
    }

}
