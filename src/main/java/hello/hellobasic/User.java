package hello.hellobasic;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class User {

    @NotEmpty(message = "비밀번호는 필수입니다")
    @ValidPassword(minLength = 10, message = "잘못된 비밀번호입니다. 비밀번호는 최소 10 자 이상이어야 하고 , 대문자, 소문자, 숫자를 포함해야 합니다.")
    private String password;

}