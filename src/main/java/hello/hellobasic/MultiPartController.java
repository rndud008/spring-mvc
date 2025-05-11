package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class MultiPartController {

    private static final String UPLOAD_DIR = "C:\\Users\\82108\\Desktop\\Dcon326\\spring-mvc-edu-file\\나무발발이\\";

    @GetMapping("/upload")
    public String upload() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String postUpload(HttpServletRequest request, Model model) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try(InputStream in  = request.getInputStream()){
            byte[] buf = new byte[1024];
            int read;
            while((read = in.read(buf)) != -1){
                buffer.write(buf, 0, read);
            }
        }
        byte[] byteArray = buffer.toByteArray();
        String rawData = new String(byteArray);
        System.out.println("rawData = " + rawData);

        model.addAttribute("rawData", rawData);

        return "result";
    }

    @PostMapping("/uploadFile1")
    public String postUploadFile1(HttpServletRequest request, Model model) throws IOException, ServletException {

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        Part filePart = request.getPart("file");
        String submittedFileName = filePart.getSubmittedFileName();
        System.out.println("filePart = " + filePart);

        long size = filePart.getSize();
        System.out.println("size = " + size);

        String contentType = filePart.getContentType();
        System.out.println("contentType = " + contentType);

        String filePath = UPLOAD_DIR + File.separator + submittedFileName;

        try(InputStream in = filePart.getInputStream()){
            Files.copy(in, Paths.get(filePath));
        }

        return "result";
    }

    @PostMapping("/uploadFile2")
    public String postUploadFile2(@RequestParam String username, @RequestParam("file") MultipartFile file) throws IOException, ServletException {

        String originalFilename = file.getOriginalFilename();
        file.getSize();
        file.getContentType();

        File file1 = new File(UPLOAD_DIR + File.separator + originalFilename);
        file.transferTo(file1);

        return "result";
    }

}
