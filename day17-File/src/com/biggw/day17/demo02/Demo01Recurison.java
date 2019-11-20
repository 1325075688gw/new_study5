package com.biggw.day17.demo02;

/**
 * @author gw
 * @date 2019/11/9 0009 上午 11:33
 */


/*
 * 递归计算:
 *      我们需要知道递归起始条件,和终止条件
 *      正向递归时候,起始:1,终止:50
 *      反向递归时候,起始:50,终止:1
 *
 * 递归的目的:
 *      叠加数字
 *
 *
 * */
public class Demo01Recurison {
    public static void main(String[] args) {
        int res1 = sum(100);
        System.out.println("res1 = " + res1);

        int res2 = sum2(1, 100);
        System.out.println("res2 = " + res2);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int sum2(int n, int stop) {
        if (n == stop) {
            return stop;
        }
        return n++ + sum2(n, stop);
    }
}
