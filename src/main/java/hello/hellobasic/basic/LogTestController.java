package hello.hellobasic.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        System.out.println("name = " + name);

//        log.trace("trace log="+name); // 잘못된 사용방법 - 연산처리

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info ={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }
}
