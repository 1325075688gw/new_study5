package com.biggw.join;

/**
 * @author gw
 * @date 2019/12/12 0012 下午 17:06
 */
public class Test1 implements Person {
    public static void main(String[] args) {
        // 接口中不能定义构造方法
        System.out.println();
        Test1 test1 = new Test1();
        System.out.println();
    }
}

interface Person {
    int a = 0;
}
