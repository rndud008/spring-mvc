package hello.hellobasic.config;

import hello.hellobasic.repository.ItemRepository;
import hello.hellobasic.repository.jdbctemplate.JdbcTemplateItemRepositoryV3;
import hello.hellobasic.repository.mybatis.ItemMapper;
import hello.hellobasic.repository.mybatis.MyBatisItemRepository;
import hello.hellobasic.service.ItemService;
import hello.hellobasic.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }
}
