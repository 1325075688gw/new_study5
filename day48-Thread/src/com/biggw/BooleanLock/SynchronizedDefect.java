package com.biggw.BooleanLock;

import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/13 0013 上午 10:53
 */
public class SynchronizedDefect {
    public synchronized void syncMethod(){
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefect synchronizedDefect = new SynchronizedDefect();
        new Thread(synchronizedDefect::syncMethod, "T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(synchronizedDefect::syncMethod, "T2").start();
    }
}
