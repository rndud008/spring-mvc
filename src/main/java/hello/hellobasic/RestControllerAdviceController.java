package hello.hellobasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class RestControllerAdviceController {

    @GetMapping(value = "/exception2")
    public String exception() {
        throw new IllegalArgumentException("IllegalArgumentException error");
    }
}
