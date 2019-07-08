package redis;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lijinpeng on 2019/6/10.
 */
public class ThreadPoolTest {


    @Test
    public void testThreadPool() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        threadPoolExecutor.execute(new MyThread());
        threadPoolExecutor.shutdown();
        TimeUnit.SECONDS.sleep(10000);
    }

    public class MyThread implements Runnable {

        public void run() {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行中");
                }
            } catch (Exception e) {
                System.out.println("抛异常拉！！");
            }
        }
    }
}
