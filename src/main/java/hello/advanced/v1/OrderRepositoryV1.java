package hello.advanced.v1;

import hello.advanced.hellotrace.HelloTraceV1;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;
    public void save(String itemId){
        TraceStatus status = trace.begin("OrderRepositoryV1.save");
        try {
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!!!!!");
            }
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep (millis);
        }catch (InterruptedException e){
               e.printStackTrace ();
        }
    }
}
