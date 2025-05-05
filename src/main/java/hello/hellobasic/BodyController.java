package hello.hellobasic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BodyController {

    @GetMapping("/user1")
    public User user1() {
        return new User("springmvc",10);
    }

    @GetMapping("/user2")
    public ResponseEntity<User> user2() {
        User user = new User("springmvc",10);
        return new ResponseEntity<>(user, HttpStatus.OK); // User 객체가 JSON 형식으로 반환되고 상태 코드는 200 OK가 된다
    }
}
