package com.biggw.day18.demo04;

import java.util.Properties;
import java.util.Set;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 14:19
 */


/*
 * java.util.Properties extends Hashtab<k,v> implements Map<k,v>
 * Properties表示一个持久的属性集合,Propeties可以保存到流中或从流中加载
 * Properties是唯一一个和IO流相结合的集合
 *       Properties中的store()方法,可以把集合中临时数据持久化到硬盘中存储
 *       Properties中的Load()方法,可以将硬盘中文件(键值对),读取到集合中使用
 * Properties中键值都是字符串
 *
 *
 * Properties中特有的方法.
 *       Object setProperty(String key, String value) 调用Hashtab中的put方法
 *       String getProperty(String key)  相当于Map中的get(key)
 *       Set<String> stringPropertyNames() 相当于Map中的keySet()方法
 * */
public class Demo01Properties {

    public static void main(String[] args) {
        // 我们不用指定泛型,因为默认键值都是字符串
        Properties properties = new Properties();
        properties.setProperty("无延期", "23");
        properties.setProperty("蓝张力", "33");
        properties.setProperty("梁总包", "43");

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            System.out.println("string + \" \" + properties.getProperty(string) = " + string + " " + properties.getProperty(string));
        }

    }
}
