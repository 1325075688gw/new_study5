package com.biggw.day23.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 14:46
 */
public class Demo02ReflectConstructor {
    public static void main(String[] args) throws Exception {

        Person person = new Person();
        Class pClass = person.getClass();

        Constructor constructor = pClass.getConstructor(String.class, String.class);
        Object obj1 = constructor.newInstance("小强", "小黑");
        System.out.println("obj1 = " + obj1);

        // 构造无参的对象
        Constructor constructor1 = pClass.getConstructor();
        Object obj2 = constructor1.newInstance();
        System.out.println("obj2 = " + obj2);

        // 构造无参的对象(推荐使用这种方法)
        Object obj3 = pClass.newInstance();
        System.out.println("obj3 = " + obj3);


    }
}
