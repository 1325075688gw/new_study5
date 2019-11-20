package com.biggw.day22.demo03.ObjectMethodRefence;

import javax.naming.Name;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 21:34
 */
public class Demo01ObjectMethodRefence {
    public static void main(String[] args) {
        String name ="小强";

        func(name,data-> System.out.println("data = " + data));


        // 对象方法引用
        ObjectRefence<String> objectRefence = new ObjectRefence();
        func(name, objectRefence::printObjectRefence);


        // 匿名对象的使用方式：
        // new 类名称().成员变量
        // new 类名称().成员方法

        // 所以这儿不能下面这种写法
        // func(name,new ObjectRefence<String>()::printObjectRefence);
    }

    public static <T> void func (T t,Printable<T> printable){
        printable.printObject(t);
    }
}

class ObjectRefence <E>{
    public void printObjectRefence(E obj){
        System.out.println("obj = " + obj);
    }
}


interface Printable <T>{
    public abstract void printObject(T t);
}