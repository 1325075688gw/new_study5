package com.biggw.BooleanLock;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author gw
 * @date 2019/12/13 0013 下午 12:02
 */
public class Synchronized4 {
    private final static Object mutex = new Object();

    public synchronized void accessResource(){
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        final Synchronized4 synchronized4 = new Synchronized4();
        for (int i = 0; i < 4; i++) {
            new Thread(synchronized4::accessResource).start();
        }
    }
}
