package com.biggw.day23.ReflectPractice;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 23:02
 */
public class Person {
    private String name;


    public void study(){
        System.out.println(name+": 正在愉快的学习");
    }

    public Person(String name) {
        this.name = name;

    }
}
