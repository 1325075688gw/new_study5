package com.biggw.day23.ZhuJiePractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gw
 * @date 2019/11/14 0014 下午 12:48
 */


/*
我们这儿就是通过注解完成了,通过配置文件来进行反射

 */

@reflect(className = "com.biggw.day23.ZhuJiePractice.Person",methodName = "eat")
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        // 获取该类的字节码文件对象
        Class<Main> mainClass = Main.class;

        // 获取注解的实现类对象
        reflect annotation = mainClass.getAnnotation(reflect.class);


        /*

        public class reflectImpl implements reflect{
            public String className(){
                // 将上面的注解属性写进去
                return "com.biggw.day23.ZhuJiePractice.Person";
            }

            public String methodName(){
                //将上面的注解属性填进去
                return "eat";
            }

        }

        // 多态
        reflect obj = new reflectImpl();
         */


        // 调用上面的className()方法,返回"com.biggw.day23.ZhuJiePractice.Person"
        String className = annotation.className();

        // 调用上面的methodName()方法,返回"eat"
        String methodName = annotation.methodName();

        // 现在我们通过全类名加载类的字节码文件进内存,获取字节码对象的引用
        Class<?> aClass = Class.forName(className);

        Constructor<?> constructor = aClass.getConstructor();
        Constructor<?> constructor1 = aClass.getConstructor(String.class);
        Object newInstance = constructor.newInstance();
        Object newInstance1 = constructor1.newInstance("小强");


        Method methodEat = aClass.getMethod(methodName);
        methodEat.invoke(newInstance);
        methodEat.invoke(newInstance1);

    }
}
