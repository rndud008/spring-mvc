package hello.hellobasic;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

@RestController
public class DefaultParamController {

    @GetMapping("/webRequest")
    public String webRequestExample(WebRequest webRequest, NativeWebRequest nativeWebRequest) {

        String name = webRequest.getParameter("name");
        String customHeader = webRequest.getHeader("X-Custom-Header");
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        String clientIp = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        return "Hello, " + name + "! Custom Header Value: " + customHeader + ", Client IP: " + clientIp + ", User-Agent: " + userAgent;
    }

    @PostMapping("/params")
    public void params(HttpServletResponse response, HttpSession session, HttpMethod httpMethod,
                       InputStream inputStream, OutputStream outputStream, Principal principal) throws IOException {


        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 0;
        }
        visitCount++;
        session.setAttribute("visitCount", visitCount);

        // ObjectMapper를 사용하여 request.getInputStream()으로 전달된 JSON 데이터를 RequestData 객체로 매핑
        ObjectMapper objectMapper = new ObjectMapper();
        RequestData requestData = objectMapper.readValue(inputStream, RequestData.class);

        // Principal: 인증된 사용자 정보 추출 (없으면 "Anonymous")
        String username = (principal != null) ? principal.getName() : "Anonymous";

        // OutputStream Writer: 응답 본문 작성
        String responseText = String.format(
                "HTTP Method: %s\nSession Visit Count: %d\nPrincipal: %s\nRequest Data: %s",
                httpMethod, visitCount, username, requestData.toString());

        response.setContentType("text/plain;charset=UTF-8");
        try (OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            writer.write(responseText);
            writer.flush();
        }
    }
}