package com.biggw.day22.demo01.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 19:28
 */

/*
 * Stream流中常用方法,filter(),对Stream流中的数据进行过滤
 * Stream<T> filter(Predicate<? super T> predicate);
 *
 * filter()方法的参数是Predicate接口实现类对象,所以可以使用lambda表达式,对数据进行过滤
 *
 * Predicate中的抽象方法
 *      boolean test(T t);
 *
 *
 * Stream流属于管道流,只能被消费一次
 * 第一个Stream流调用方法完成之后,数据就会流向下一个Stream流
 * 而这时第一个Stream流已经使用完毕,就会关闭了
 * 所以第一个Stream流不能再调用方法了   IllegalStateException:stream has aleady been operated upon or closed
 *
 * */
public class Demo04StreamFilter {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        // ArrayList<String> arrayList = null; NullPointerException 一旦赋值后,就不能二次赋值了
        Collections.addAll(arrayList, "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "高圆圆,女");
        Stream<String> stream = arrayList.stream();

        // filter()方法返回的也是一个流对象
        Stream<String> stream1 = stream.filter(data -> data.split(",")[1].equals("女"));
        stream1.forEach(data -> System.out.println(data));

    }
}
