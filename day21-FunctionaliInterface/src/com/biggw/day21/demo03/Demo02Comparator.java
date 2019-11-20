package com.biggw.day21.demo03;

import com.sun.source.tree.ReturnTree;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 22:26
 */

/*
 * 使用函数式接口作为方法的返回值
 * 对数字降序排列
 *
 * */
public class Demo02Comparator {
    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30, 40};
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));
        System.out.println();

        integers[0] = 90;
        Arrays.sort(integers, (Integer i1, Integer i2) -> {
            return i2 - i1;
        });
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));
        System.out.println();


        integers[0] = 100;
        Arrays.sort(integers, (i1, i2) -> i2 - i1);
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));
        System.out.println();


        System.out.println("使用函数式接口作为方法的返回值");
        System.out.println();


        Comparator<Integer> comparatorAnonymous = getComparatorAnonymous();
        integers[0] = 110;
        Arrays.sort(integers, getComparatorAnonymous());
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));
        System.out.println();


        Comparator<Integer> comparatorFunctionalInterface = getComparatorFunctionalInterface();
        integers[0] = 120;
        Arrays.sort(integers, getComparatorFunctionalInterface());
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));
        System.out.println();


        Comparator<Integer> comparatorFunctionalInterfaceJianXie = getComparatorFunctionalInterfaceJianXie();
        integers[0] = 130;
        Arrays.sort(integers, getComparatorFunctionalInterfaceJianXie());
        System.out.println("原始数据: "+ Arrays.toString(integers));
        System.out.println("从大到小: "+ Arrays.toString(integers));


    }

    private static Comparator<Integer> getComparatorAnonymous() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer s, Integer t1) {
                return t1 - s;
            }
        };
    }

    // 使用函数式接口作为方法的方法值
    private static Comparator<Integer> getComparatorFunctionalInterface() {
        return (Integer i1, Integer i2) -> {
            return i2 - i1;
        };
    }

    private static Comparator<Integer> getComparatorFunctionalInterfaceJianXie() {
        return (i1, i2) -> i2 - i1;
    }
}

