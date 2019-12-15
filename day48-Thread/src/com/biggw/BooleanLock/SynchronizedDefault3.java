package com.biggw.BooleanLock;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/13 0013 上午 10:53
 */
public class SynchronizedDefault3 {
    public synchronized void syncMethod(){
//        try {
//            System.out.println(Thread.currentThread().getName());
//            TimeUnit.SECONDS.sleep(0);
        System.out.println("fff");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();
        SynchronizedDefect synchronizedDefect = new SynchronizedDefect();
        Thread t1 = new Thread((()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }), "T1");
        t1.start();
//        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread((()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName());
            }
        }), "T2");
        t2.start();
//        TimeUnit.SECONDS.sleep(1);
//        t2.interrupt();
//        System.out.println(t2.isInterrupted());
//        System.out.println(t2.getState());

    }
}
