package hello.hellobasic;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // initBinder 사용시 생성자를 통해서도 주입됨. init 바인더를 통해 제외를 원할시 사용하지 말아야함.
public class User {
    private String username;
    private String email;
    private String password;
}
