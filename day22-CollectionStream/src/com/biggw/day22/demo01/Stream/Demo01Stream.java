package com.biggw.day22.demo01.Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 16:35
 */

/*
 * 使用Stream流的方式,遍历集合,对集合中的数据进行过滤
 * Stream流是 JDK 1.8之后出现的
 * 关注的是做什么,而不是怎么做
 *
 * filter 过滤
 * map 映射
 * lambda
 * */
public class Demo01Stream {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("张三丰");
        strings.add("张无忌");
        strings.add("张大千");
        strings.add("张角");
        strings.add("刘备");

        /*
        以前的做法
        for (String s : strings) {
            xxx;
        }
        for (String s : strings) {
            xxx;
        }
         */


        // stream()将集合转换为流
        // filter()方法的参数是Predicate<T> pre 实现类对象
        // forEach()方法的参数是Consumer<T> con 实现类对象
        strings.stream().filter(name->name.startsWith("张"))
                        .filter(name->name.length()==3)
                        .forEach(name-> System.out.println(name));


    }
}
