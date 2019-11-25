package com.biggw.day23.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 21:52
 */
public class Demo03ReflectMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class pClass = person.getClass();


        // 获取指定名称的方法
        Method eat = pClass.getMethod("eat",String.class);
        Method run = pClass.getMethod("run");

        // 执行方法名
        eat.invoke(person,"小强");
        run.invoke(person);

        // 获取所有public 方法
        // 这儿会把Object类里面的方法,打印出来,因为基继承
        Method[] methods = pClass.getMethods();

        for (Method method : methods) {
            System.out.println("method = " + method);
            // 获取方法名的间写
            String name = method.getName();
            System.out.println("name = " + name);
        }


    }
}
