package com.biggw.day22.demo04.StaticMethodRefence;

/**
 * @author gw
 * @date 2019/11/12 0012 下午 22:02
 */

/* 静态方法引用
 * Math::abs  (通过类名::静态方法  代替lambda函数表达式)
 *
 * */
public class Demo01StaticMethodRefence {
    public static void main(String[] args) {
        int input = -10;
        int res = func(input, data -> Math.abs(data));
        System.out.println("res = " + res);


        // 使用静态方法引用
        res = func(-2, Math::abs);

    }

    public static int func(int input, AbsAble absAble) {
        return absAble.absMethod(input);
    }
}

// 计算绝对值接口
interface AbsAble {
    public abstract int absMethod(int input);
}