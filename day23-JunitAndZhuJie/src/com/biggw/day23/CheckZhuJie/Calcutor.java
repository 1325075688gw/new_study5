package com.biggw.day23.CheckZhuJie;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 14:03
 */
public class Calcutor {
    @Check
    public void add(){
        System.out.println("1+2 = " +(1+2));
    }

    @Check
    public void sub(){
        System.out.println("1-2 = " + (1-2));
    }

    @Check
    public void mul(){
        System.out.println("1*2 = " + (1*2));
    }

    @Check
    public void div(){
        System.out.println("1/0 = " + (1/0));
    }

    // 这个函数我们不需要校验,我们就可以不加上注解
    public void normal(){
        System.out.println("没有bug");
    }
}
