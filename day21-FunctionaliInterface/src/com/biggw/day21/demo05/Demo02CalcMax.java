package com.biggw.day21.demo05;

import java.util.function.Supplier;

/**
 * @author gw
 * @date 2019/11/12 0012 上午 10:36
 */


/*
 * 用函数式接口计算数组的最大值
 * 如果要使用函数式接口,一来就必须想到【定义一个函数,这个函数的参数或者返回值是函数式接口】
 *
 *
 * 题目要求:
 *      求数组的最大值
 *
 * */
public class Demo02CalcMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9,8,7};
        int max = getMax(()->{
            int tmp = arr[0];
            for (int i : arr) {
                if(i>tmp){
                    tmp = i;
                }
            }
            return tmp;
        },arr);
        System.out.println("max = " + max);
    }

    public static int getMax(Supplier<Integer> supplier, int[] arr) {
        return supplier.get();
    }
}
