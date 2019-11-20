package com.biggw.day21.demo03;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 22:17
 */

/*
 * 使用函数式接口作为参数实现多线程
 *
 *
 * */
public class Demo01Runable {
    public static void main(String[] args) {
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        startThread(()-> System.out.println(Thread.currentThread().getName()));
    }

    public static void startThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
