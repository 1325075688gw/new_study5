package com.biggw.day22.demo07.ArrayConstructorRefence;

import java.util.Arrays;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 23:39
 */


/*
 * 数组的构造器引用
 *
 * 必要条件:
 *      1.数组的类型
 *      2.数组的长度
 *
 * */




public class Demo01ArrayConstructorReference{
    public static void main(String[] args) {
        Integer[] arrs1 =  func(10,length->{
                return new Integer[length];}
            );

        System.out.println("length_1 = " + arrs1.length);
        System.out.println("arrs_2 = " + Arrays.toString(arrs1));
        System.out.println("=============================");

        String[] arrs2 = func(10, String[]::new);
        System.out.println("length_2 = " + arrs2.length);
        System.out.println("arrs_2 = " + Arrays.toString(arrs2));

    }

    /**
     *
     * @param length
     * @param arrayCreater
     * @param <E>
     * @return
     */
    public static <E> E[] func(int length, ArrayCreater<E> arrayCreater){
        E[] arr = arrayCreater.create(length);
        return arr;
    }
}


interface ArrayCreater<T>{
    public abstract T[] create(int length);
}