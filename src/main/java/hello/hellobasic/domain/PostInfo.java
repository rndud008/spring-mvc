package hello.hellobasic.domain;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostInfo {
    private Long id;
    private String title;
    private MultipartFile file;
    private FileUploadInfo fileUploadInfo;

    public PostInfo(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
