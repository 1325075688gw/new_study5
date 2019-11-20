package com.biggw.day21.demo05;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 15:16
 */
public class Demo08Practice {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        // ArrayList<String> arrayList = null; NullPointerException 一旦赋值后,就不能二次赋值了
        Collections.addAll(arrayList, "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "高圆圆,女");

        ArrayList<String> res = null;
        res = func(arrayList, (data) -> data.split(",")[0].length() == 4, (data) -> data.split(",")[1].equals("女"));
        for (String re : res) { 
            System.out.println(re);
        }
    }

    public static ArrayList<String> func(ArrayList<String> arrayList, Predicate<String> predicate1, Predicate<String> predicate2) {
        // ArrayList<String> res = null; NullPointerException 一旦赋值后,就不能二次赋值了
        ArrayList<String> res = new ArrayList<>();
        for (String s : arrayList) {
            if (predicate1.and(predicate2).test(s)) {
                res.add(s);
            }
        }
        return res;
    }
}
