package com.biggw.day23.zhuJie;

/**
 * @author gw
 * @date 2019/11/14 0014 上午 10:25
 */
public @interface MyFirst {
    public abstract String name();
    public abstract String local();
    public abstract int age() default 23;
}
