package hello.hellobasic;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class RequestEntityController {

    @PostMapping("/requestEntity1")
    public ResponseEntity<String> requestEntity1(RequestEntity<User> requestEntity) {

        User user = requestEntity.getBody();
        HttpHeaders headers = requestEntity.getHeaders();

        System.out.println("headers = " + headers);
        HttpMethod method = requestEntity.getMethod();

        System.out.println("method = " + method);
        URI url = requestEntity.getUrl();
        System.out.println("url = " + url);

        return new ResponseEntity<>("User: Name=" + user.getUsername() + ", email= " + user.getEmail(), HttpStatus.OK);

    }

    @PostMapping("/requestEntity2")
    public ResponseEntity<User> requestEntity2() {

        RestTemplate template = new RestTemplate();
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8081")
                .path("/users/{name}")
                .build("springmvc");

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .build();

        ResponseEntity<User> response = template.exchange(request, User.class);

        return response;
    }

    @GetMapping("/users/{name}")
    public User users(@PathVariable String name) {
        return new User(name, "a@a.com");
    }
}
