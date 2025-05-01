package hello.hellobasic;

import hello.hellobasic.config.JdbcTemplateV1Config;
import hello.hellobasic.config.MemoryConfig;
import hello.hellobasic.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;


//@Import(MemoryConfig.class)
@Import(JdbcTemplateV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.hellobasic.web")
public class HelloBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBasicApplication.class, args);
    }

    @Bean
    @Profile("local")
    public TestDataInit testDataInit(ItemRepository itemRepository) {
        return new TestDataInit(itemRepository);
    }
}
