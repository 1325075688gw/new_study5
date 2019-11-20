package com.biggw.day23.ZhuJiePractice;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 12:43
 */
public class Person {
    private String name;

    public Person() {
    }

    public void eat(){
        System.out.println(name+"正在吃东西");
    }

    public Person(String name) {
        this.name = name;
    }
}
