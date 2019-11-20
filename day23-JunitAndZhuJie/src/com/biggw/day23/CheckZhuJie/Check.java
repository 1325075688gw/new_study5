package com.biggw.day23.CheckZhuJie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 14:01
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
// Serializable也叫做标记型接口,这个Check注解也类似标记型接口
public @interface Check {
}
