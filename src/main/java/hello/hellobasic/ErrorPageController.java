package io.springmvc.springmvcmaster;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@Slf4j
public class ErrorPageController {

    // 401 에러 페이지
    @GetMapping("/viewError")
    public void viewError(HttpServletResponse response) throws IOException {
        response.sendError(404);
    }

    // 401 에러 페이지
    @GetMapping("/jsonError")
    public void jsonError(HttpServletResponse response) throws IOException {
        response.sendError(401);
    }
}