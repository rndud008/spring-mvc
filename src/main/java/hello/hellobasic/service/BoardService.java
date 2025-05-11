package hello.hellobasic.service;

import hello.hellobasic.domain.FileUploadInfo;
import hello.hellobasic.domain.PostInfo;
import hello.hellobasic.repository.FileUploadRepository;
import hello.hellobasic.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    private final PostRepository postRepository;
    private final FileUploadRepository fileUploadRepository;

    public PostInfo save(PostInfo postInfo) throws IOException {
        PostInfo post = postRepository.save(postInfo);
        MultipartFile multipartFile = post.getFile();
        return fileUpload(multipartFile, post);
    }

    private PostInfo fileUpload(MultipartFile multipartFile, PostInfo post) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extension = originalFilename.substring(index);
        String storedFileName = UUID.randomUUID() + extension;
        String filePath = uploadDir + File.separator + storedFileName;
        File destFile = new File(filePath);
        multipartFile.transferTo(destFile);

        FileUploadInfo fileUploadInfo = new FileUploadInfo(
                0L,
                originalFilename,
                storedFileName,
                multipartFile.getContentType(),
                multipartFile.getSize(),
                filePath
        );
        fileUploadRepository.save(fileUploadInfo);
        post.setFileUploadInfo(fileUploadInfo);

        return post;
    }

    public List<PostInfo> getPosts() {
        return postRepository.findAll();
    }

    public FileUploadInfo findFileById(Long id) {
        return fileUploadRepository.findById(id);
    }

}