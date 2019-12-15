package com.biggw.wait;

import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 23:46
 */
public class EventClient {
    public static void main(String[] args) {
        EventQueue eventQueue = new EventQueue();
        new Thread(()->{for (;;){
            EventQueue.Event event = eventQueue.take();
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        },"后台处理系统").start();


        new Thread(()->{
            for (;;){
                // 创建静态内部类对象
                eventQueue.offer(new EventQueue.Event());
                try {
                    TimeUnit.MILLISECONDS.sleep(666);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "业务端").start();


    }
}
