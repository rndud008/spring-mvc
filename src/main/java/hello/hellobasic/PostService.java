package hello.hellobasic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostClient postClient;
    private final AtomicInteger counter = new AtomicInteger(1);

    public Post getPostById(int id) {

        return postClient.getPostById(id);

    }

    public void createPost(Post post) {
        post.setId(counter.getAndIncrement());
        postClient.createPost(post);
    }

    public List<Post> getPosts() {

        return postClient.getPosts();

    }
}
