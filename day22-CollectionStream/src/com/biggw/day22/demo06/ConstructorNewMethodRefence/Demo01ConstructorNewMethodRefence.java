package com.biggw.day22.demo06.ConstructorNewMethodRefence;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 23:26
 */

/*
 * 类的构造器(构造方法)引用
 *
 *
 *
 * */
public class Demo01ConstructorNewMethodRefence {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(func("小强", name -> new Person(name)));
        people.add(func("大冬瓜", Person::new));

        Stream<Person> stream = people.stream();
        stream.forEach(data -> System.out.println(data.toString()));

    }

    public static Person func(String name, PersonCreater pc) {
        return pc.create(name);
    }
}

class Person {
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person() {
    }

    // 要使用类的构造器引用,必须要实现构造函数
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//加上函数式接口注解
@FunctionalInterface
interface PersonCreater {
    public abstract Person create(String name);
}