package com.biggw.BooleanLock;

import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/13 0013 上午 10:53
 */
public class SynchronizedDefect2 {
    public synchronized void syncMethod(){
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedDefect2 synchronizedDefect = new SynchronizedDefect2();
        Thread t1 = new Thread(synchronizedDefect::syncMethod, "T1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(synchronizedDefect::syncMethod, "T2");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
