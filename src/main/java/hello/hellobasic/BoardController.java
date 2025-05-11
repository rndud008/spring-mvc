package hello.hellobasic;

import hello.hellobasic.domain.FileUploadInfo;
import hello.hellobasic.domain.PostInfo;
import hello.hellobasic.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/upload")
    public String uploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public ResponseEntity<PostInfo> postUpload(@RequestPart("post") PostInfo post,
                                               @RequestPart(value = "files", required = false) List<MultipartFile> files) throws IOException {
        PostInfo postInfo = boardService.save(post, files);
        return ResponseEntity.ok().body(postInfo);
    }

    @GetMapping("/listForm")
    public String listFiles() {
        return "list";
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostInfo>> list() throws IOException {
        List<PostInfo> posts = boardService.getPosts();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        FileUploadInfo fileInfo = boardService.getFileById(id);
        if (fileInfo != null) {
            Path filePath = Paths.get(fileInfo.getFilePath());
            if (Files.exists(filePath)) {
                response.setContentType(fileInfo.getContentType());
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileInfo.getOriginalFilename() + "\"");
                Files.copy(filePath, response.getOutputStream());
                response.getOutputStream().flush();
            }
        }
    }
}
