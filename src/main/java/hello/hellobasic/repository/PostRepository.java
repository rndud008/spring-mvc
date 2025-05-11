package hello.hellobasic.repository;

import hello.hellobasic.domain.PostInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {

    private final Map<Long, PostInfo> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PostInfo save(PostInfo postInfo) {
        long id = idGenerator.getAndIncrement();
        postInfo.setId(id);
        storage.put(id, postInfo);
        return postInfo;
    }

    public List<PostInfo> findAll() {
        return new ArrayList<>(storage.values());
    }
}