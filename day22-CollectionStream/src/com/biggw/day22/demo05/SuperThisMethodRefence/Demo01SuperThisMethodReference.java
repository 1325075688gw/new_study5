package com.biggw.day22.demo05.SuperThisMethodRefence;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 22:36
 */


/*
 * super引用父类的成员方法
 * super::成员方法
 *
 *
 * */


public class Demo01SuperThisMethodReference {
    public static void main(String[] args) {
        String name = "小强";
        func(name, data -> System.out.println("使用lambda欢迎: " + data));

        // 对象::方法   完成方法引用
        Zi zi = new Zi();
        func(name, zi::sayHello);

        System.out.println("==================上面沒有体现父子类关系===================");

        Fu zi1 = new Zi();
        // 父类没有show()方法,所以需要向下转型
        Zi zi2 = (Zi) zi1;
        zi2.show(name);
        zi2.show1(name);
        zi2.show2(name);
        // 调用自己的show()方法
        System.out.println("调用自己的show()方法");
        zi2.show3(name);
        zi2.show4(name);

    }

    // 这次不是在这调用含有函数式接口的方法,因为在这调用无法体现出父类和子类的关系,就用不了【super::sayHello】【this::sayHello】
    public static void func(String name, Greetable greetable) {
        greetable.greet(name);
    }
}

class Fu {
    public void sayHello(String name) {
        System.out.println("欢迎你: " + name);
    }
}

class Zi extends Fu {
    @Override
    public void sayHello(String name) {
        name = "可爱的" + name;
        super.sayHello(name);
    }

    public void method(String name, Greetable greetable) {
        greetable.greet(name);
    }

    // 在这创建调用含有接口参数的方法,之后再外面再来调用这个方法,这么做是为了体现【子类调用父类的方法super::sayHello】
    public void show(String name) {
        method(name, data -> {
            Fu fu = new Fu();
            fu.sayHello(data);
        });
    }

    // 在这创建调用含有接口参数的方法,之后再外面再来调用这个方法,这么做是为了体现【子类调用父类的方法super::sayHello】
    public void show1(String name) {
        // 因为在这我们可以使用lambda函数式编程接口完成第二个参数,当然了,这就为我们后面把函数式接口变成【super:: 和 this::】提供了基础
        //【核心,其实我们单纯点,就看里面method()方法,其实就是我们来完成method()的函数式编程】
        method(name, data -> super.sayHello(data));
    }

    public void show2(String name) {
        method(name, super::sayHello);
    }

    public void show3(String name) {
        method(name, data->this.sayHello(data));
    }

    public void show4(String name) {
        method(name, this::sayHello);
    }
}

interface Greetable {
    public abstract void greet(String name);
}


/*
使用lambda欢迎: 小强
欢迎你: 可爱的小强
==================上面沒有体现父子类关系===================
欢迎你: 小强
欢迎你: 小强
欢迎你: 小强
调用自己的show()方法
欢迎你: 可爱的小强
 */