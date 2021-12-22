package hello.advanced.v1;

import hello.advanced.hellotrace.HelloTraceV1;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    public final OrderRepositoryV1 orderRepositoryV0;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){
        TraceStatus status = trace.begin("OrderServiceV1.orderItem");
        try {
            orderRepositoryV0.save (itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
}
