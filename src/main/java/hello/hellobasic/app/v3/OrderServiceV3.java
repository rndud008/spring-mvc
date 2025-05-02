package hello.hellobasic.app.v3;

import hello.hellobasic.trace.TraceId;
import hello.hellobasic.trace.TraceStatus;
import hello.hellobasic.trace.hellotrace.HelloTraceV2;
import hello.hellobasic.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem( String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
            // 예외를 꼭 다시 던져줘어야 함
        }


    }
}
