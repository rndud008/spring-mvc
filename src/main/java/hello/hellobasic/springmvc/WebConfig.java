package hello.hellobasic.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hello.hellobasic.springmvc") // 패키지 변경 가능
public class WebConfig {

}