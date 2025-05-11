package hello.hellobasic.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostInfo {
    private Long id;
    private String title;  // 게시글 제목
    private String content; // 게시글 내용
    private String userId; // 사용자 ID
    private String comment; // 댓글

    private List<FileUploadInfo> files = new ArrayList<>(); // 업로드된 파일 리스트 (DB 저장용)
    private List<MultipartFile> uploadFiles; // 클라이언트에서 받은 파일들
}
