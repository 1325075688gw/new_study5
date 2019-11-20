package com.biggw.day21.demo05;

import com.sun.source.tree.ReturnTree;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 16:03
 */

/*
* 需求,
* 1.截取年龄
* 2.转化为数字
* 3.数字加10
*
* */
public class Demo11ApplyAndThenThree {
    public static void main(String[] args) {
        String age = "哈利波特,123";
        Integer res = applyAndThenThree(age, (data)->data.split(",")[1],(data)->Integer.parseInt(data),(data)->data+10);
        System.out.println("res = " + res);
        System.out.println(res instanceof Integer);
    }

    // Function<String, String> 可以同种类型的数据进行转换
    public static int applyAndThenThree(String s, Function<String,String> function1, Function<String,Integer> function2, Function<Integer,Integer> function3){
        return function1.andThen(function2).andThen(function3).apply(s);
    }
}
