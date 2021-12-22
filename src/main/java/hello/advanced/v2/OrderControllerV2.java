package hello.advanced.v2;

import hello.advanced.hellotrace.HelloTraceV2;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId){
        TraceStatus status = trace.begin("OrderControllerV1.request");
        try {
            orderService.orderItem(status.getTraceId(),itemId);
            trace.end(status);
            return "ok";
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }

    }
}
