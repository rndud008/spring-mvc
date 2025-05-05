package hello.hellobasic;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ResponseEntityController {

    @GetMapping("/body1")
    public ResponseEntity<User> body1(@RequestBody User user){
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/body2")
    public ResponseEntity<User> body2(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/body3")
    public ResponseEntity<User> body3(@RequestBody User user){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Custom-Value");
        return new ResponseEntity<>(user, header, HttpStatus.CREATED);
    }

    @GetMapping("/body4")
    public ResponseEntity<User> body4(@RequestBody User user){
        HttpHeaders header = new HttpHeaders();
        header.add("Custom-Header", "Custom-Value");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Custom-Header", "Custom-Value")
                .location(URI.create("/usrs/"+ user.getId()))
                .body(user);
    }


}
