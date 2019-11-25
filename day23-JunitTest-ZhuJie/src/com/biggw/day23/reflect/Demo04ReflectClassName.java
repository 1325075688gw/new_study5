package com.biggw.day23.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 21:52
 */
public class Demo04ReflectClassName {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class pClass = person.getClass();

        // 获取类名
        String className = pClass.getName();
        System.out.println("className = " + className);

    }
}
