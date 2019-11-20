package com.biggw.day22.demo01.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 20:08
 */

/*
 * Stream流中常用的静态方法,concat()
 * 如果有两个流,希望合并成一个流,那么可以使用Stream流中的静态方法concat()方法
 *
 * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 * 和 java.util.String中的concat()方法是不同的
 *
 * */
public class Demo09StreamStaticConcat {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("小萝卜");
        Stream<String> stream2 = Stream.of("爱吃青菜");
        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(data -> System.out.println(data));

    }
}
