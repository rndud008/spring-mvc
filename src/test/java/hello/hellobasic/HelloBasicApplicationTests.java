package hello.hellobasic;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void contextLoads() throws Exception {

        RestClient restClient = RestClient.builder().baseUrl("http://localhost:8081").build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();

        PostClient client = factory.createClient(PostClient.class);
        client.createPost(new Post(1, "springmvc", "Welcome to Spring mvc", 1));

    }

}
