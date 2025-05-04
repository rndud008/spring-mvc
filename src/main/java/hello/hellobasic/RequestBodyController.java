package hello.hellobasic;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyController {

    @PostMapping("/httpEntity")
    public ResponseEntity<User> users(HttpEntity<User> httpEntity) {
        User user = httpEntity.getBody();
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/requestBody", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> users(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/text", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> text(@RequestBody String data) {
        return ResponseEntity.ok(data);
    }

    @PostMapping(value = "/notRequestBody", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> noRequestBody(User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/noData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> noData(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/required", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> required(@RequestBody(required = false) User user) {
        return ResponseEntity.ok(user);
    }

}