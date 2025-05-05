package hello.hellobasic;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {

    @NotEmpty(message = "사용자명은 필수입니다.")
    @Size(min = 3, max = 15, message = "사용자명은 3~15 길이어야 합니다.")
    private String username;

    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String email;

    @Min(value = 0, message = "나이는 0 보다 커야 합니다.")
    @Max(value = 120, message = "나이는 120 보다 같거나 작아야 합니다.")
    private int age;
}