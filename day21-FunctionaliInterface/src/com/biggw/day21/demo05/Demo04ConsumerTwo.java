package com.biggw.day21.demo05;

import java.util.function.Consumer;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 13:39
 */

/*
 * Consumer接口的默认方法andThen
 * 作用：需要两个Consumer接口,可以把两个Consumer接口组合到一起,再对两个数据进行消费.每个接口可以定义不同的消费方式
 * Consumer con1 = xxx;
 * Consumer con2 = xxx;
 * String s = "hello";
 * con1.accept(s);
 * con2.accept(s);
 *
 * 对于上面的实现我们可以连接两个Consumer接口,再进行消费
 *
 * con1.andThen(con2).accept(s); 谁写在前边谁先消费
 *
 *     default Consumer<T> andThen(Consumer<? super T> after) {
 *       Objects.requireNonNull(after);
 *       return (t) -> {
 *
 * 【重要】两个接口是分别消费,而不是级联消费
 *           this.accept(t);
 *           after.accept(t);
 *       };
 *   }
 *
 *
 * */
public class Demo04ConsumerTwo {
    public static void main(String[] args) {
        String name = "小强";
        consumerTwoAndThen(name, (String data) -> {
            System.out.println("消费数据: " + data + ",你好");
        }, (String data) -> {
            String string = new StringBuffer(name).reverse().toString();
            System.out.println("反转数据: " + string);
        });
    }

    public static void consumerTwo(String name, Consumer<String> consumer1, Consumer<String> consumer2) {
        consumer1.accept(name);
        consumer2.accept(name);
    }

    public static void consumerTwoAndThen(String name, Consumer<String> consumer1, Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept(name);
    }
}
