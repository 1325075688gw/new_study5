package com.biggw.day21.demo05;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 14:34
 */


/*
 * 逻辑表达式:可以连接多个判断条件
 * &&:与运算
 *
 * 需求:判断一个字符串,有两个判断条件
 *      1.判断字符串的长度是否大于5
 *      2.判断字符串中是否包含a
 *
 * 我们还是用Predicate函数式接口实现
 * Predicate接口中有三个默认方法：and  or  negate
 *
 *
 *   default Predicate<T> and(Predicate<? super T> other) {
 *       Objects.requireNonNull(other);
 *       // 重写test()中的方法,这个test里面分别调用各自接口自定义的test()方法
 *       // 然后以lambda的实现方式返回一个实现类对象
 *       return (t) -> {
 *           return this.test(t) && other.test(t);
 *       };
 *   }
 *
 *   default Predicate<T> negate() {
 *       return (t) -> {
 *           return !this.test(t);
 *       };
 *   }
 *
 *   default Predicate<T> or(Predicate<? super T> other) {
 *       Objects.requireNonNull(other);
 *       return (t) -> {
 *           return this.test(t) || other.test(t);
 *       };
 *   }
 *
 * 然后调用test()方法
 * boolean test(T t):
 *      符合条件:返回true
 *      不符合条件:返回false
 *
 * */
public class Demo07PredicateAnd {
    public static void main(String[] args) {

        String name = "absfa";
        boolean res = true;
        res = test(name, (data) -> data.contains("a"), (data) -> data.length() > 5);
        System.out.println("res = " + res);
        res = testAnd(name, (data) -> data.contains("a"), (data) -> data.length() > 5);
        System.out.println("res = " + res);

        String s = "小强";
        res = testNegate(s, (data)-> Objects.equals("小强",data));
        System.out.println("res = " + res);

    }

    public static boolean test(String s, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.test(s) && predicate2.test(s);
    }

    public static boolean testAnd(String s, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.and(predicate2).test(s);
    }
    
    public static boolean testNegate(String s, Predicate<String> predicate){
        return predicate.negate().test(s);
    }

}
