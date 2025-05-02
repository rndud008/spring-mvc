package hello.hellobasic.config;

import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.jpa.JpaItemRepositoryV2;
import hello.hellobasic.repository.jpa.JpaItemRepositoryV3;
import hello.hellobasic.repository.jpa.SpringDataJpaItemRepository;
import hello.hellobasic.repository.v2.ItemRepositoryV2;
import hello.hellobasic.repository.v2.ItmeQueryRepositoryV2;
import hello.hellobasic.service.ItemService;
import hello.hellobasic.service.ItemServiceV1;
import hello.hellobasic.service.ItemServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class V2Config {
    private final EntityManager em;
    private final ItemRepositoryV2 itemRepositoryV2;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itmeQueryRepositoryV2());
    }

    @Bean
    public ItmeQueryRepositoryV2 itmeQueryRepositoryV2(){
        return new ItmeQueryRepositoryV2(em);
    }

    // 테스트 초기화 때문에 남겨둠.
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }
}
