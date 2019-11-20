package com.biggw.day21.demo05;

import java.util.function.Consumer;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 13:53
 */

/*
 * 按照格式:"姓名:xx  性别:xx"将原始数据进行消费
 *
 * */
public class Demo05ConsumerFormat {
    public static void main(String[] args) {
        String[] strings = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        consumerFormat(strings,
                (data) -> System.out.print("姓名: " + data.split(",")[0] + "    "),
                (data) -> System.out.println("性别: " + data.split(",")[1]));
    }

    public static void consumerFormat(String[] strings, Consumer<String> consumer1, Consumer<String> consumer2) {
        for (String string : strings) {
            consumer1.andThen(consumer2).accept(string);
        }
    }
}
