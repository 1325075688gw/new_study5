package com.biggw.join;

import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/12 0012 上午 11:59
 */
public class DemoJoin02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    sleepTime(1);
                }
            }
        }, "gw_1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    sleepTime(1);
                }
            }
        }, "gw_2");
        thread2.start();
        thread2.join();


        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            sleepTime(1);
        }
    }

    private static void sleepTime(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
