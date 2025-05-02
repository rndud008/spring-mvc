package hello.hellobasic.config;

import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.jpa.JpaItemRepositoryV1;
import hello.hellobasic.repository.jpa.JpaItemRepositoryV2;
import hello.hellobasic.repository.jpa.SpringDataJpaItemRepository;
import hello.hellobasic.service.ItemService;
import hello.hellobasic.service.ItemServiceV1;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {
    private final SpringDataJpaItemRepository springDataJpaItemRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(springDataJpaItemRepository);
    }
}
