package hello.hellobasic.repository;

import hello.hellobasic.domain.PostInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {

    private final Map<Long, PostInfo> postStorage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PostInfo save(PostInfo post) {
        Long id = idGenerator.getAndIncrement();
        post.setId(id);
        postStorage.put(id, post);
        return post;
    }

    public List<PostInfo> findAll() {
        return new ArrayList<>(postStorage.values());
    }
}