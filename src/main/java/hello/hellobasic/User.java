package hello.hellobasic;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {

    @NotNull(message = "사용자명은 필수입니다.")
    @Size(min = 3, max = 15, message = "사용자명은 3~15 길이 입니다.")
    private String username;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Min(value = 0, message = "나이는 0 보다 커야 합니다.")
    @Max(value = 120, message = "나이는 120 보다 같거나 작아야 합니다.")
    private int age;

//    @Size(min = 6, max = 12, message = "패스워드는 6~12 길이 입니다.")
//    @Min(value = 6, message = "비빌번호는 6 보다 커야 합니다.")
//    private int password; //@Size 는 java.lang.Integer 형을 변환하는 Validator 가 존재하지 않아서 오류발생, String 으로 정의하면 정상작동

}