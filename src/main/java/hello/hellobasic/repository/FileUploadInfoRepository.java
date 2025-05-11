package hello.hellobasic.repository;

import hello.hellobasic.domain.FileUploadInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FileUploadInfoRepository {

    private final Map<Long, FileUploadInfo> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public FileUploadInfo save(FileUploadInfo fileUploadInfo) {
        long id = idGenerator.getAndIncrement();
        fileUploadInfo.setId(id); // ID 설정
        storage.put(id, fileUploadInfo);
        return fileUploadInfo;
    }

    public Optional<FileUploadInfo> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

}
