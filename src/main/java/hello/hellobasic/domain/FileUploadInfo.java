package hello.hellobasic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadInfo {
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private String contentType;
    private long fileSize;
    private String filePath;
}