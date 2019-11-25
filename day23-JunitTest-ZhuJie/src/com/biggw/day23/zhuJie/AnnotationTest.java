package com.biggw.day23.zhuJie;

/**
 * @author gw
 * @date 2019/11/14 0014 上午 10:25
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @MyFirst(name = "小强", local = "重庆")
        int a = 5;

        // SuppressWarnings 没有写属性名,所以该属性只有一个value属性
        @SuppressWarnings("all")


        // 局部变量不可以用注解
        // 枚举类型赋值,枚举类型赋值,数组类型赋值用{},只有一个元素的数组进行赋值,我们可以省略{}
        // @AnnotationValue(value = 23, person = Person.p1, MY_FIRST = @MyFirst(name = "小强", local = "重庆"), color = {"红色", "黄色"}, size = "中号")
        int b = 5;
    }

    // 枚举类型赋值,枚举类型赋值,数组类型赋值用{},只有一个元素的数组进行赋值,我们可以省略{}
    @AnnotationValue(value = 23, person = Person.p1, MY_FIRST = @MyFirst(name = "小强", local = "重庆"), color = {"红色", "黄色"}, size = "中号")
    int b = 5;
}
