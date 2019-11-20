package com.biggw.day21.demo05;

import java.util.function.Consumer;

/**
 * @author gw
 * @date 2019/11/12 0012 上午 10:48
 */


/*
 * java.util.function.Consumer<T> 接口:是一个消费型接口
 * 也就是消费数据,具体的数据类型由泛型指定
 *
 * void accept(T var1);消费一个指定泛型的数据
 *
 * 至于怎么消费,需要自己定义(输出,计算)
 *
 *
 * */
public class Demo03Consumer {
    public static void main(String[] args) {
        String name = "小强";
        consumerData(name, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("匿名内部类消费数据: " + s);
            }
        });

        consumerData(name, (String s)->{
            System.out.println("函数式接口消费数据: " + s);
        });

        consumerData(name, (s)-> System.out.println("(简写)函数式接口消费数据: "+s));

        consumerData(name, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("匿名内部类消费数据: " + s);
                String string = new StringBuffer(s).reverse().toString();
                System.out.println("string = " + string);
            }
        });

    }

    public static void consumerData(String data,Consumer<String> consumer){
        consumer.accept(data);
    }
}
