package com.biggw.day22.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 19:44
 */


/*
 * 如果要将流中的数据映射为另一种类型的数据,我们可以使用map方法
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 *
 * 该接口需要一个Function函数式接口参数,可以将当前流中的T类型数据转化为R类型数据
 *
 * Function中的抽象方法
 *      R apply(T t)
 * 将String类型的数组转化为int型数组
 *
 *
 * */
public class Demo05StreamMap {
    public static void main(String[] args) {
        // 将String类型的数组转化为int型数组
        Stream<String> stream = Stream.of("1", "2", "3", "5", "6", "7");

        // map返回的也是一个流对象,我们可以继续调用流方法
        stream.map(data -> Integer.parseInt(data)).filter(data -> data <= 5).forEach(data -> System.out.println(data));

    }
}
