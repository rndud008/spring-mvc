package hello.hellobasic;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {

    private int id;
    private String title;
    private String body;
    private int userId;

}