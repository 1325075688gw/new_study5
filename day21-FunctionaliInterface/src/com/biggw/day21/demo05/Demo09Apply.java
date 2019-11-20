package com.biggw.day21.demo05;

import java.util.function.Function;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 15:35
 */

/*
 * 【类型转换接口】
 *  java.util.function.Function<T,R> 接口用来根据一个类型的数据转换到另一个类型的数据
 * 其中的抽象方法,R apply(T var1);
 *
 * 需求:将String类型数据转化为Integer
 *
 *
 * */
public class Demo09Apply {
    public static void main(String[] args) {
        String s = "12345";
        int res = applyFunc(s, (data) -> Integer.parseInt(data));
        System.out.println("res = " + res);
    }

    public static Integer applyFunc(String s, Function<String, Integer> function) {
        return function.apply(s);
    }
}
