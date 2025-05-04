package hello.hellobasic.custom;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDynamicController {

    public String postDynamic(){
        return "Post Request";
    }
}