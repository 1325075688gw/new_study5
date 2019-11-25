package com.biggw.day23.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 14:46
 */
public class Demo01Reflect {
    public static void main(String[] args) throws Exception {

        Person person = new Person();
        Class pClass = person.getClass();

        Field[] fields = pClass.getFields();
        System.out.println(Arrays.toString(fields));


        // 经验证,只有public修饰的成员变量才能被getField
        Field a = pClass.getField("a");

//        NoSuchFieldException: b
//        Field b = pClass.getField("b");
//        Field c = pClass.getField("c");
//        Field d = pClass.getField("d");
        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);
//        System.out.println("d = " + d);

        Object objA = a.get(person);
        System.out.println("objA = " + objA); // 输出为null

        // 给a设置"小强"
        a.set(person, "小强");
        objA = a.get(person);
        System.out.println("objA = " + objA); // 输出小强


//        Object objB = b.get(person);
//        System.out.println("objB = " + objB);

//        Object objC = c.get(pClass);
//        System.out.println("objC = " + objC);

//        Object objD = d.get(pClass);
//        System.out.println("objD = " + objD);



        // 如果想要获取所有成员变量,可以使用pClass.getDeclaredFields(),但是我们不能访问具体的数据,只是可以看见有什么成员变量
        Field[] declaredFields = pClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // 我们如果想要访问某些成员变量,我们可以先设置->忽略访问权限修饰符的安全检查,也就是说在Class字节码面前,没有什么是私有的
        Field d = pClass.getDeclaredField("d");
        d.setAccessible(true);
        // 忽略访问权限修饰符的安全检查
        Object objD = d.get(person);
        System.out.println("objD = " + objD);



    }
}
