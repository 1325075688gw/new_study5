package com.biggw.day13.demo03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author gw
 * @date 2019/11/5 0005 下午 21:46
 */


/*
 * java.util.Collections是集合工具类,用来对集合进行操作,常用方法如下
 *
 * 1.public static <T> boolean addAll(Collection<T> c, T...elements); 往集合中添加一些元素
 * 2.public static void shuffle(List<?> list); 将集合中的数据打乱
 * 3.public static void shuffle(List<?> list, Random r); 将集合中的数据按照随机种子进行打乱, Random r = new Random(123),123是一个随机数
 * 4.public static <T> void sort(List<T> list); 将集合中的数据按照默认规则进行排序
 * 5.public static <T> void sort(List<T> list, Comparator<? super T>); 将集合中的数据按照指定规则进行排 序
 *
 *
 *
 * */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        // 多态
        Collection<String> collection = new ArrayList<>();

/*        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        以前是这种添加元素的方式,操作非常麻烦,所以推荐添加多个元素用Collections.addAll
        */


        // Collections.addAll添加多个元素,之后还可以继续添加
        // ArrayList<String> arrayList = null; NullPointerException 一旦赋值后,就不能二次赋值了
        // 所以要区别他们之间的区别,所以推荐 ArrayList<String> arrayList = new ArrayList<>();
        // Collections.addAll静态方法添加多个元素

        ArrayList<String> arrayList2 = new ArrayList<String>();
        Collections.addAll(arrayList2,"f","h");


        Collections.addAll(arrayList, "a", "b", "c");
        Collections.addAll(arrayList, "d","e");

        // Collection集合只能添加集合
        arrayList.addAll(arrayList2);

        System.out.println("arrayList = " + arrayList);
        System.out.println("=====================");
        Collections.shuffle(arrayList);
        System.out.println("arrayList = " + arrayList);

        System.out.println("============================");
        // 使用Collection接口中的成员方法addAll方法进行添加集合(【注意:这儿添加的是Conllection<? extends E>】) 也就是说添加的一个集合.
        // Collections.addAll静态方法添加多个元素
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList2);


    }
}
