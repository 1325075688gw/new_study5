package com.biggw.day17.demo02;

/**
 * @author gw
 * @date 2019/11/9 0009 上午 11:44
 */

/*
 * 计算阶层
 *
 * */
public class Demo02Recurison {
    public static void main(String[] args) {
        int res1 = func1(10);
        System.out.println("res1 = " + res1);

        int res2 = func2(1, 10);
        System.out.println("res2 = " + res2);
    }

    private static int func2(int n, int stop) {
        if (n == 10) {
            return n;
        }
        return n++ * func2(n, stop);
    }

    public static int func1(int n) {
        if (n == 1) {
            return 1;
        }
        return n * func1(n - 1);
    }
}
