package hello.hellobasic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private String username;
    private String email;

    public User(@BindParam("my-name") String username, @BindParam("my-email") String email) {
        this.username = username;
        this.email = email;

    }

}