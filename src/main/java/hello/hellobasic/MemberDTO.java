package hello.hellobasic;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String username;
    private Integer age;

    public MemberDTO(){

    }

    public MemberDTO(String username, Integer age){
        this.username = username;
        this.age = age;
    }
}
