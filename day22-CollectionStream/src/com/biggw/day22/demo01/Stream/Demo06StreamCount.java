package com.biggw.day22.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 19:54
 */


/*
 * Stream流中常用方法,count()方法用来统计Stream流中的个数,返回long值
 * 
 * long count();
 * 
 * count()方法是一个终结方法,返回值是一个long类型的整数
 * 所以不能在继续调用Stream流中的其他方法
 *
 * */
public class Demo06StreamCount {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "5", "6", "7");

        long count = stream.count();
        System.out.println("count = " + count);
    }
}
