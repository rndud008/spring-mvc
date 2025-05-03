package hello.hellobasic.config.v1_proxy.conncrete_proxy;

import hello.hellobasic.app.v2.OrderServiceV2;
import hello.hellobasic.trace.TraceStatus;
import hello.hellobasic.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        // 구현체 로 할경우 부모클래스에 주입받는것을 null 로 처리해줘야함
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");
            // target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
