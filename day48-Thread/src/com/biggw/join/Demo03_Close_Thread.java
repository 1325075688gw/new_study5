package com.biggw.join;

import java.util.concurrent.TimeUnit;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 16:06
 */
public class Demo03_Close_Thread {
    static class MyTask extends Thread{
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("启动");
            while(!closed && !this.isInterrupted()){

            }
            System.out.println("结束");
        }

        private void close(){
            this.closed = true;
            this.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        myTask.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("关闭系统");
        myTask.close();
    }
}
