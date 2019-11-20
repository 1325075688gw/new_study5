package com.biggw.day22.demo02.MethodRefence;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 20:57
 */


// 使用方法引用的时候,参数的类型必须对应上,否则会报错

public class Demo01Printable {
    public static void main(String[] args) {
        printObject("你好", new PrintableImpl<String>());
        printObject("你好", (data) -> System.out.println(data + ",Python"));


        // 方法引用符号::  ,如果一个lambda表达式表示的函数方案,已经存在于某个方法的实现中,那我们可以通过::把该对象的对应方法结果来使用,这样我们就不需要写
        // lambda表达式了

        // System.out是一个对象,对象里面的方法println和我们即将写的lambda表示式想表达的意思相同,所以我们省略lambda表达式的书写,
        // 直接将System.out对象的println方法接过来使用.

        // 使用方法引用的时候,参数的类型必须对应上,否则会报错
        printObject("你好,",System.out::println);
    }

    public static <E> void printObject(E e, Printable<E> printable) {
        printable.print(e);
    }
}


class PrintableImpl<T> implements Printable<T> {
    @Override
    public void print(T s) {
        System.out.println(s);
    }
}

interface Printable<T> {
    public abstract void print(T s);
}
