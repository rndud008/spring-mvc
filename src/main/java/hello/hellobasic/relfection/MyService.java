package hello.hellobasic.relfection;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @CustomAnnotation
    public String serviceMethod1(String param, long version) {
        return "Hello " + param + " " + version;
    }

    @CustomAnnotation
    public int serviceMethod2(int count) {
        return count * 2;
    }
}