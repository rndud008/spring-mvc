package hello.hellobasic.config;

import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.jpa.JpaItemRepositoryV1;
import hello.hellobasic.service.ItemService;
import hello.hellobasic.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    private final EntityManager em;

    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV1(em);
    }
}
