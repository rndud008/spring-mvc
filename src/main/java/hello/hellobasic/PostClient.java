package hello.hellobasic;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange("/posts")
public interface PostClient {

    @GetExchange("/{id}")
    Post getPostById(@PathVariable int id);

    @GetExchange
    List<Post> getPosts();

    @PostExchange
    void createPost(@RequestBody Post post);
}
