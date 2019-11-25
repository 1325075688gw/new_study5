package com.biggw.day23.ReflectPractice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/13 0013 下午 23:01
 */

/**
 * 一个类对应一个类加载器
 */


public class StructPractice {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 创建Properties对象
        Properties properties = new Properties();
        ClassLoader classLoader = StructPractice.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("help.properties");
        properties.load(resourceAsStream);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        // 全类名加载类
        Class aClass = Class.forName(className);
        Constructor constructor = aClass.getConstructor(String.class);
        Object instance = constructor.newInstance("小强");

        Method method = aClass.getMethod(methodName);
        method.invoke(instance);

    }
}
