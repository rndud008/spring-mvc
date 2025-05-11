package hello.hellobasic;

import hello.hellobasic.domain.FileUploadInfo;
import hello.hellobasic.domain.PostInfo;
import hello.hellobasic.service.BoardService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String upload() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String postUpload(@ModelAttribute("post") PostInfo post) throws IOException {
        boardService.save(post);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<PostInfo> posts = boardService.getPosts();
        model.addAttribute("posts", posts);
        return "list";
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable Long id, HttpServletResponse response) throws IOException {
        FileUploadInfo fileInfo = boardService.findFileById(id);
        if(fileInfo != null){
            Path path = Paths.get(fileInfo.getFilePath());
            if(Files.exists(path)){
                response.setContentType(fileInfo.getContentType());
                response.setHeader("Content-Disposition", "attachment; filename=\""+ fileInfo.getOriginalFileName() + "\"");
                Files.copy(path, response.getOutputStream());
                response.getOutputStream().flush();
            }
        }
    }

}
