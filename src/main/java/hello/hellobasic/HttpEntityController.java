package hello.hellobasic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class HttpEntityController {

    @PostMapping("/param")
    public String handleRequestParam(@RequestParam String username) {
        return "username: " + username;
    }

    @PostMapping("/model")
    public String handleModelAttribute(@ModelAttribute User user) {
        return "username: " + user.getUsername() + ", email: " + user.getEmail();
    }

    @PostMapping("/readbody")
    public String readBody(HttpServletRequest request) throws IOException {

        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        return "Body: " + requestBody.toString();
    }


    @PostMapping("/httpEntity1")
    public ResponseEntity<String> handleHttpEntity1(HttpEntity<String> httpEntity) throws JsonProcessingException {

        String body = httpEntity.getBody();
        HttpHeaders headers = httpEntity.getHeaders();
        System.out.println("headers = " + headers);

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(body, User.class);

        return new ResponseEntity<>("User: Name=" + user.getUsername() + ", email= " + user.getEmail(), HttpStatus.OK);

    }

    @PostMapping("/httpEntity2")
    public ResponseEntity<String> handleHttpEntity2(HttpEntity<User> httpEntity) {

        User user = httpEntity.getBody();
        HttpHeaders headers = httpEntity.getHeaders();
        System.out.println("headers = " + headers);

        return new ResponseEntity<>("User: Name=" + user.getUsername() + ", email= " + user.getEmail(), HttpStatus.OK);

    }
}