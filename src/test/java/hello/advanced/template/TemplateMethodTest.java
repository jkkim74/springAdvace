package hello.advanced.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic();
        logic2();
    }

    private void logic() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직 1 실행!!!");

        long endTime = System.currentTimeMillis();

        long resultTime = endTime = startTime;

        log.info("resultTime={}",resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직 2 실행!!!");

        long endTime = System.currentTimeMillis();

        long resultTime = endTime = startTime;

        log.info("resultTime={}",resultTime);
    }

    @Test
    void templateMethod1(){
        AbstractTemplate template = new SubClassLogic1();
        template.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethod2(){
        AbstractTemplate template = new AbstractTemplate () {
            @Override
            protected void call() {
                log.info("비즈니스 1");
            }
        };
        log.info("익명클래스1 : "+template.getClass());
        template.execute();

        AbstractTemplate template2 = new AbstractTemplate () {
            @Override
            protected void call() {
                log.info("비즈니스 2");
            }
        };
        log.info("익명클래스2 : "+template2.getClass());
        template2.execute();
    }
}
