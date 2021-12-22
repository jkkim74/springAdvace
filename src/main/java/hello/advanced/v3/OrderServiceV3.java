package hello.advanced.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    public final OrderRepositoryV3 orderRepositoryV0;
    private final LogTrace trace;

    public void orderItem(String itemId){
        TraceStatus status = trace.begin("OrderServiceV3.orderItem");
        try {
            orderRepositoryV0.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
}
