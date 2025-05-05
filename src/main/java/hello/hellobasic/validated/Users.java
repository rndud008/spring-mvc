package hello.hellobasic.validated;

import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Users {

    @NotEmpty(message = "사용자명은 필수입니다.", groups = {VGroups.CreateGroup.class})
    private String username;

    @Email(message = "이메일 형식에 맞지 않습니다.", groups = {VGroups.CreateGroup.class, VGroups.UpdateGroup.class})
    private String email;

}