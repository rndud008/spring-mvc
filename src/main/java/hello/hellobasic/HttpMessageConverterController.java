package hello.hellobasic;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpMessageConverterController {

    // 1) StringHttpMessageConverter 사용
    @PostMapping(value = "/text", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String handleText(@RequestBody String body) {
        // 단순 텍스트를 받음
        return "text: " + body;
    }

    // 2) MappingJackson2HttpMessageConverter 사용
    @PostMapping(value = "/json", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User handleJson(@RequestBody User user) {
        user.setUsername("springboot");
        return user;
    }

    // 3) FormHttpMessageConverter 사용
    @PostMapping(value = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String handleForm(@RequestBody MultiValueMap<String, String> formData) {
        String username = formData.getFirst("username");
        String email = formData.getFirst("email");

        // 간단한 처리 후 응답
        return "username=" + username + ", age=" + email;
    }
}