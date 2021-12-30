package hello.advanced.trace.strategy;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1<T>{

    private Strategy<T> strategy;
    private LogTrace trace;
    private String logMsg;

    public ContextV1(Strategy<T> strategy, String logMsg,LogTrace trace) {
        this.strategy = strategy;
        this.logMsg = logMsg;
        this.trace = trace;
    }

    public String execute(){
        TraceStatus status = trace.begin(logMsg);
        try {
            strategy.call();
            trace.end(status);
            return "ok";
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }
    }
}
