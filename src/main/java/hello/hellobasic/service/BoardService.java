package hello.hellobasic.service;

import hello.hellobasic.domain.FileUploadInfo;
import hello.hellobasic.domain.PostInfo;
import hello.hellobasic.repository.FileUploadInfoRepository;
import hello.hellobasic.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final FileUploadInfoRepository fileUploadInfoRepository;
    private final PostRepository postRepository;

    @Value("${file.upload.dir}")
    private String uploadDir;

    public PostInfo save(PostInfo postInfo, List<MultipartFile> files) throws IOException {

        postRepository.save(postInfo);
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                FileUploadInfo uploadedFile = fileUpload(file);
                postInfo.getFiles().add(uploadedFile);
            }
        }
        return postInfo;
    }

    private FileUploadInfo fileUpload(MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename(); // 원본파일명
        int dotIndex = originalFilename.lastIndexOf('.');
        String extension = null;
        if (dotIndex > 0) {
            extension = originalFilename.substring(dotIndex); // 확장자
        }
        String storedFilename = UUID.randomUUID().toString() + extension;  // 실제 업로드 파일명
        String filePath = uploadDir + File.separator + storedFilename;  // 파일 저장 풀 경로

        File destFile = new File(filePath);
        multipartFile.transferTo(destFile);

        FileUploadInfo uploadInfo = new FileUploadInfo(
                0L,
                originalFilename,
                storedFilename,
                multipartFile.getSize(), //파일 크기
                multipartFile.getContentType(), //컨텐트 타입
                filePath
        );

        return fileUploadInfoRepository.save(uploadInfo);

    }

    public List<PostInfo> getPosts() {
        return postRepository.findAll();
    }

    public FileUploadInfo getFileById(Long id) {
        Optional<FileUploadInfo> file = fileUploadInfoRepository.findById(id);
        return file.orElse(null);
    }
}