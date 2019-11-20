package com.biggw.day21.demo05;

import java.util.function.Function;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 15:44
 */


/*
 * Function接口中的默认方法,andThen()用来进行【级联】转换类型操作
 *      default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
 *          Objects.requireNonNull(after);
 *          return (t) -> {
 *              【级联操作1】前面结果分享给后面作为输入
 *              return after.apply(this.apply(t));
 *          };
 *      }
 *
 * 将字符串1234转换为int类型,然后加10,然后转化为字符串返回
 * */
public class Demo10ApplyAndThen {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println("s = " + s);
        String res = applyAndThen(s, (data) -> Integer.parseInt(data) + 10, (data) -> String.valueOf(data));
        System.out.println("res = " + res);
        System.out.println(res instanceof String);
    }

    // Function<String,Integer> 不能用int,必须用包装类型
    public static String applyAndThen(String s, Function<String, Integer> function1, Function<Integer, String> function2) {
        return function1.andThen(function2).apply(s);
    }
}
