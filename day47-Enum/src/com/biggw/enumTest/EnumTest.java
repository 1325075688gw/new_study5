package com.biggw.enumTest;


import org.junit.Assert;

import java.util.stream.IntStream;

/**
 * @author gw
 * @date 2019/12/10 0010 下午 23:54
 */
public class EnumTest {
    public enum Animal{
        PIG("小猪"),
        DOG("小狗");

        private String name;

        public static Animal findByName(String name){
            Animal[] values = Animal.values();
            System.out.println("============");
            for (Animal animal : values) {
                System.out.println(animal);
                Assert.assertTrue("类型不一致",animal instanceof Animal);
                System.out.println("------------");
                if(animal.name.equals(name)){
                    System.out.println(animal);
                    System.out.println(name+"   "+animal.ordinal());
                    return animal;
                }
            }
            return null;
        }

        Animal(String name) {
            this.name = name;
            System.out.println("构造函数"+name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String name = "小狗";
        Animal byName = Animal.findByName(name);
        if(byName == null){
            return ;
        }

        switch (byName){
            case DOG:
                System.out.println(byName.name+"   "+byName.ordinal()+"   "+byName.getName());
                break;
            case PIG:
                System.out.println(byName.name+"   "+byName.ordinal()+"   "+byName.getName());
                break;
            default:
                System.out.println("未查找到数据！");
        }


        System.out.println(Animal.PIG);
        // 相当于一个实例对象，可以调用方法
        System.out.println(Animal.PIG.getName());



    }
}
