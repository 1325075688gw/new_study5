package com.biggw.wait;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 23:31
 */
public class EventQueue {
    private final int max;
    private final static int DEFAULT_MAX_EVENT = 10;
    public static class Event{}

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max){
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(eventQueue.size() >= max){
                console("任务队列满");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("新任务被提交");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.size() == 0){
                console("任务队列空");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("提交的任务被处理");
            Event event = eventQueue.removeFirst();
            eventQueue.notify();
            return event;
        }
    }

    public void console(String msg){
        System.out.printf("%s %s \n",Thread.currentThread().getName(), msg);
    }
}
