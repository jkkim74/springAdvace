package hello.advanced.threadlocal;

import hello.advanced.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field(){

        Runnable userA = () -> fieldService.logic("userA");

        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        //sleep(2000);
        sleep(100);
        threadB.start();
        sleep(3000);
        log.info("main exit");

    }

    private void sleep(int i) {
        try {
            System.out.println(Thread.currentThread());
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
