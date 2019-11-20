package com.biggw.day21.demo01;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 21:00
 */

/*
 * 函数式接口可以作为一个方法的参数,和返回值类型
 *
 * 最后在out文件中生成了4个.class
 * MyFunctionalInterfaceImpl.class
 * MyFunctionalInterface.class
 * Main.class
 * Main$1.class【匿名内部类生成的】
 *
 * 观察可以发现,使用函数式接口可以省略.class文件,运行时候就少加载文件到内存,所以函数式接口的效率比匿名内部类高一些
 *
 *
 * */

public class Main {
    public static void main(String[] args) {
        // 常规调用
        myImpl(new MyFunctionalInterfaceImpl());

        // 匿名内部类
        myImpl(new MyFunctionalInterface() {
            @Override
            public void func() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });


        // 因为方法的参数是函数式接口:函数式接口,有且仅有一个抽象方法的接口,称之为函数式接口
        // 所以可以用lambda表达式
        myImpl(() -> {
            System.out.println("使用lambda表达式重写接口中的抽象方法");
        });

        // lambda进行缩写
        myImpl(() -> System.out.println("使用lambda的缩写形式"));

    }

    private static void myImpl(MyFunctionalInterface myInter) {
        myInter.func();
    }
}


class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void func() {
        System.out.println("常规法,先实现接口");
    }
}


