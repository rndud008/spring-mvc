package hello.hellobasic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{
    private String url;
    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }


    @PostConstruct
    public void init() throws Exception {
        // 메서드이름을 자유롭게 줄수 있고 스프링 빈이 스프링 코드에 의존 하지 않음
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        // 메서드이름을 자유롭게 줄수 있고 스프링 빈이 스프링 코드에 의존 하지 않음
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
