package redis;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lijinpeng on 2019/6/11.
 */
public class NoFileLock implements Serializable {
    /**
     * false 表示 ReentrantLock 的非公平锁
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public void testFail() {
        try {
            lock.lock();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock.testFail();
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
