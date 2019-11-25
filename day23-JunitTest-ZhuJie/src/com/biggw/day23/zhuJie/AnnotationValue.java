package com.biggw.day23.zhuJie;

import java.lang.annotation.*;

/**
 * @author gw
 * @date 2019/11/14 0014 上午 10:43
 */



@Documented //是否把注解生成到doc文档中
@Retention(RetentionPolicy.CLASS) // 当前被描述的注解,会保留到.class文件中,并被读取到JVM中;如果写SOURCE,那么连.class文件中都没有该注解
@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.TYPE}) // 可以将注解使用在方法,类,成员变量上
public @interface AnnotationValue {
    // 如果只有一个属性需要复制,推荐使用value属性,这样我们在使用注解的时候,我们就不需要写value了,直接赋值就好了
    // @AnnotationValue(value=23)
    // @AnnotationValue(23)   推荐
    int value();
    String name() default "小强";
    String local() default "北京";

    // 枚举类型,person不是p1,p2,在这就是一个普通的变量名
    Person person();

    // 注解类型
    MyFirst MY_FIRST();

    // 数组类型
    String[] color();
    String[] size();

}
