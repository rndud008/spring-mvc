package hello.hellobasic.web;

import hello.hellobasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    public final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
