package hello.hellobasic;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public String processRequest(User user) {
        return "Hello from MyService, " + user.getUsername() + ": " + user.getEmail();
    }
}
