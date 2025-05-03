package hello.hellobasic.aop.exam;

import hello.hellobasic.aop.exam.annotation.Retry;
import hello.hellobasic.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;

    // 5번 에 1번 실패하는 요청
    @Trace
    @Retry(4)
    public String save(String itemId){
        seq++;
        if (seq % 5 == 0){
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
