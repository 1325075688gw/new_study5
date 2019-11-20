package com.biggw.day22.demo01.Stream;

import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 19:19
 */

/*
 * Stream<T> filter(Predicate<? super T> var1);
 *
 * Stream流中常用方法:forEach()
 *      void forEach(Consumer<? super T> action);
 *      该方法接受一个Consumer接口实现类对象,然后把数据进行处理
 *
 *      Consumer接口是一个消费型的函数式接口,可以使用lambda进行数据消费
 *
 *
 * forEach用来遍历流中的数据,是一个终结方法,遍历之后就不能再继续调用Stream流中的其他方法
 *
 *
 * */
public class Demo03StreamForEach {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(data-> System.out.println(data));


    }
}
