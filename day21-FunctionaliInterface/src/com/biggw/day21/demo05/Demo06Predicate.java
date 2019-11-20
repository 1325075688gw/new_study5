package com.biggw.day21.demo05;

import com.sun.source.tree.ReturnTree;

import javax.naming.Name;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 14:08
 */

/*
 * java.util.function.Predicate<T>接口
 *
 *作用：对某种数据类型的数据进行自定义判断（比如判断数组元素个数是否大于5,字母是否都是大写,等）,返回boolean值
 * boolean test(T t):
 *      符合条件:返回true
 *      不符合条件:返回false
 *
 *
 *
 * */

public class Demo06Predicate {
    public static void main(String[] args) {
        String name = "小强";
        boolean res =  testData(name, (data)-> Objects.equals("大灰狼",data));
        System.out.println("res = " + res);

        name = "大灰狼";
        res = testData(name, (data)-> Objects.equals("大灰狼",data));
        System.out.println("res = " + res);

    }

    public static boolean testData(String s, Predicate<String> predicate){
        return predicate.test(s);
    }
}
