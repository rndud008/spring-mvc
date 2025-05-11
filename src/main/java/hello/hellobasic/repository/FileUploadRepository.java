package hello.hellobasic.repository;

import hello.hellobasic.domain.FileUploadInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FileUploadRepository {

    private final Map<Long, FileUploadInfo> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public FileUploadInfo save(FileUploadInfo fileUploadInfo) {
        long id = idGenerator.getAndIncrement();
        fileUploadInfo.setId(id);
        storage.put(id, fileUploadInfo);
        return fileUploadInfo;
    }

    public FileUploadInfo findById(Long id) {
        return storage.get(id);
    }
}
