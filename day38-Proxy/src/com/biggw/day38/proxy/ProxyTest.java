package com.biggw.day38.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 15:26
 */
public class ProxyTest {

    public static void main(String[] args) {
        final Lenovo lenovo = new Lenovo();

        /*
            三个参数：
                1. 类加载器：真实对象.getClass().getClassLoader()
                2. 接口数组：真实对象.getClass().getInterfaces()
                3. 处理器：new InvocationHandler()
         */

        // 因为返回对象是联想代理商，所以我们可以强转为联想自己
        // 被代理对象，要想实现代理模式，就必须继承接口【必须】【刚好这儿必须转为接口类型】
        SaleComputer proxy_lenovo = (SaleComputer)Proxy.newProxyInstance(Lenovo.class.getClassLoader(), Lenovo.class.getInterfaces(), new InvocationHandler() {
        // 大小写联想都可以
        // SaleComputer proxy_lenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.class.getClassLoader(), lenovo.class.getInterfaces(), new InvocationHandler() {


             /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
                    参数：
                        1. proxy:代理对象
                        2. method：代理对象调用的方法，被封装为的对象 【 被代理对象的所有方法 】
                        3. args:代理对象调用的方法时，传递的实际参数
             */

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 1. 增强输入参数
                if (method.getName().equals("sale")) {
                    String name = (String) args[0];
                    // 2.修改逻辑
                    System.out.println("今天天气很好，");
                    // 不返回原来函数的返回值
                    method.invoke(lenovo, "帅气的" + name
                            // 2.修改逻辑
                            // 不返回原来函数的返回值
                            , args[1]);
                    // 3.修改返回值
                    return "超薄联想电脑";
                } else {
                    // 匿名内部类想使用外部类的变量，则外部类变量必须定义成final
                    return method.invoke(lenovo, args);
                }
            }
        });

        String name = proxy_lenovo.sale("小明", 5000);
        proxy_lenovo.run(name);

        // 调用真实对象，仍然会调用真是对象的方法
        String name2 = lenovo.sale("小明", 5000);
        lenovo.run(name2);
    }
}
