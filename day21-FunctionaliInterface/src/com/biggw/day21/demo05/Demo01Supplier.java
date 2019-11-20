package com.biggw.day21.demo05;

import java.util.function.Supplier;

/**
 * @author gw
 * @date 2019/11/12 0012 上午 10:23
 */

/*
 * 常用的函数式接口
 * java.util.function.Supplier<T> 接口仅包含一个午餐构造方法,T.get().用来获取一个泛型参数指定类型的对象数据
 * Supplier<T>接口被称为生产型接口,接口指定的泛型是什么类型,那么接口中get()方法就生产什么类型的数据
 * @FunctionalInterface
 * public interface Supplier<T> {
 *     T get();
 * }
 *
 * */
public class Demo01Supplier {
    public static void main(String[] args) {
        String s = getString(()->"你好");
        System.out.println("s = " + s);
    }

    public static String getString(Supplier<String> supplier){

        // 核心思想:接口对数据进行消费
        return supplier.get();
    }
}
