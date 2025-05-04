package hello.hellobasic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Controller
public class ImageUploadController {

    private static final String UPLOAD_DIR = "C:\\Users\\82108\\Desktop\\Dcon326\\spring-mvc-edu-file\\나무발발이\\";

    @GetMapping("/file")
    public String file(){
        return "file";
    }

    @PostMapping("/image/upload")
    @ResponseBody
    public ResponseEntity<String> uploadImage(@RequestBody byte[] imageBytes) {
        try {
            Path filePath = Path.of(UPLOAD_DIR + "uploaded_image.png");

            // 디렉토리 생성
            Files.createDirectories(filePath.getParent());

            // 파일 저장
            Files.write(filePath, imageBytes, StandardOpenOption.CREATE);

            return ResponseEntity.ok("이미지 업로드 성공: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("이미지 저장 실패");
        }
    }
}