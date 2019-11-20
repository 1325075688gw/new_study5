package com.biggw.day23.test;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 13:17
 */

import java.util.*;

class Initable {
    //编译期静态常量
    static final int staticFinal = 47;
    //非编期静态常量
//    static final int staticFinal2 =
//            ClassInitialization.rand.nextInt(1000);
    static int getStaticFinal1_2 = 50;

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    //静态成员变量
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    //静态成员变量
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception {
        //字面常量获取方式获取Class对象
        Class initable = Initable.class;
        System.out.println("00000000000000000000000000000000");

        System.out.println("After creating Initable ref");
        System.out.println("11111111111111111111111111111111");
        //不触发类初始化
        System.out.println(Initable.staticFinal);
        int getStaticFinal1_2 = Initable.getStaticFinal1_2;
        System.out.println("getStaticFinal1_2 = " + getStaticFinal1_2);
        System.out.println("ff");
        Class aClass = Class.forName("com.biggw.day23.test.Initable");
        System.out.println("22222222222222222222222222222222");

        //会触发类初始化
//        System.out.println(Initable.staticFinal2);
        System.out.println("33333333333333333333333333333333");

        //会触发类初始化
        System.out.println(Initable2.staticNonFinal);
        System.out.println("44444444444444444444444444444444");

        //forName方法获取Class对象
        Class initable3 = Class.forName("com.biggw.day23.test.Initable3");
        System.out.println("55555555555555555555555555555555");
        Class initable33 = Class.forName("com.biggw.day23.test.Initable3");
        System.out.println("66666666666666666666666666666666");


        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}