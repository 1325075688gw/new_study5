package com.biggw.join;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author gw
 * @date 2019/12/12 0012 上午 11:23
 */
public class DemoJoin01 {
    private final static String PREFIX = "gw_";

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = IntStream.range(1, 3).mapToObj(DemoJoin01::create).collect(Collectors.toList());
        threads.get(0).start();
        threads.get(1).start();
        threads.get(1).join();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            shortSleep(1);
        }


    }

    private static Thread create(int seq) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                    if (seq == 0) {
                        shortSleep(4);
                    } else {
                        shortSleep(1);
                    }
                }
            }
        }, PREFIX+seq);
        return thread;
    }

    private static void shortSleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
