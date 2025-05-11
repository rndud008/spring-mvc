package hello.hellobasic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadInfo {
    private Long id; // 파일 정보 ID
    private String originalFilename; // 원본 파일명
    private String storedFilename; // 저장된 파일명
    private long fileSize; // 파일 크기
    private String contentType; // MIME 타입
    private String filePath; // 저장된 파일 경로
}