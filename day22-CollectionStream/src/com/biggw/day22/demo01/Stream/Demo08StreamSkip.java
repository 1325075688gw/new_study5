package com.biggw.day22.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 20:02
 */
/*
 * Stream流中的常用方法,limit()方法,用于截取流中的元素
 *
 * Stream<T> skip(long maxSize);
 *      参数是一个long型,如果maxSize小于流中元素个数,则跳过前maxSize个元素,否则,流中元素个数就为0
 *
 * skip()方法是一个延迟方法,只对流中的数据进行截取,返回的是一个新的流,所以可以继续调用Stream流中的方法
 *
 *
 * */
public class Demo08StreamSkip {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "5", "6", "7");
        Stream<String> skip = stream.skip(3);
        skip.forEach(data -> System.out.println(data));
    }
}
