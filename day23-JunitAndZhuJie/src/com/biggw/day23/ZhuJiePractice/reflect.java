package com.biggw.day23.ZhuJiePractice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 12:44
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface reflect {
    String className();
    String methodName();
}
