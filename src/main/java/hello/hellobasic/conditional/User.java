package hello.hellobasic.conditional;

import lombok.Data;

@Data
public class User {
    @CustomAnnotation
    private String name;
}
