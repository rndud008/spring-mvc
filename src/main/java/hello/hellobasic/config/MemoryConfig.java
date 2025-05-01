package hello.hellobasic.config;


import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.memory.MemoryItemRepository;
import hello.hellobasic.service.ItemService;
import hello.hellobasic.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
