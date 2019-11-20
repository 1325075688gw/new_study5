package com.biggw.day21.demo01;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 20:55
 */



/*
 * 函数式接口,有且仅有一个抽象方法的接口,称之为函数式接口
 * 当然接口中可以包含其他方法(静态,默认,私有)
 * @FunctionalInterface注解
 *
 * 作用:可以检测接口是否是一个函数式接口
 *      是:编译通过
 *      否:编译失败(接口中的抽象方法多余一个或者没有抽象方法)
 *
 * @Override 也是注解
 * */


@FunctionalInterface
public interface MyFunctionalInterface {
    public abstract void func();
}