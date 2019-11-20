package com.biggw.day22.demo01.Stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 17:10
 */


/*
 * java.util.stream.Stream<T> 是java8新加入的流接口     (这并不是一个函数式接口)
 * 获取一个流非常简单,有以下几种常用方式
 *      1.所有Collection集合都可以通过stream()默认方法获取流  (map没有实现,我们需要实现,下面有实现过程)
 *          default Stream<E> stream()
 *      2.Stream接口中的静态方法of()可以获取数组对应的流
 *          static <T> Stream<T> of(T...values)
 *          参数可以是可变参数,也可以是一个数组
 *
 *
 * */
public class Demo02CollectionStreamAndArraysOF {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Stream<String> stream1 = arrayList.stream();

        HashSet<String> hashSet = new HashSet<>();
        Stream<String> stream2 = hashSet.stream();

        HashMap<String, String> hashMap = new HashMap<>();

        // 获取键
        Set<String> keySet = hashMap.keySet();
        Stream<String> stream3 = keySet.stream();

        // 获取值
        Collection<String> values = hashMap.values();
        Stream<String> stream4 = values.stream();

        // 获取键与值的映射关系
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        // 可变参数
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4);

        // 可变参数也可以传递数组
        int[] ints = {1,2,3,4};
        Stream<int[]> stream7 = Stream.of(ints);


    }
}
