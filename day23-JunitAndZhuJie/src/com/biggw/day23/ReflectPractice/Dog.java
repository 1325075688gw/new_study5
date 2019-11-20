package com.biggw.day23.ReflectPractice;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 23:04
 */
public class Dog {
    private String color;

    public void run(){
        System.out.println("有一只" + color+"色小狗正在吃东西");
    }

    public Dog(String color) {
        this.color = color;
    }
}
