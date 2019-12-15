package com.biggw.ThreadGroup;

/**
 * @author gw
 * @date 2019/12/13 0013 下午 14:07
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        ThreadGroup group1 = new ThreadGroup("group1");
        Thread thread = new Thread(group1,"t1");
        thread.start();

        System.out.println(thread.getThreadGroup());
        System.out.println(thread.getThreadGroup().getParent());
        System.out.println(group1.activeCount());
        Thread[] list = new Thread[4];
        int enumerate = group1.enumerate(list,false);
        System.out.println(enumerate);
        group1.


    }
}
