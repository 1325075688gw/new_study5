package com.biggw.day30.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 20:50
 */


/*
ServletContext对象 两个重要方法：
    1.String getMimeType(String var1);               【获取 Mime 类型】
    2.Object getAttribute(String var1);
      void setAttribute(String var1, Object var2);   【设置全局共享数据】

 */


@WebServlet("/demo03_Share_ServletContext")
public class Demo03_Set_Attribute_By_ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("global","全局变量");
        // 我们设置了一个键值对，现在我们可以开启 day30 这个项目，然后用A浏览器访问 Demo03 页面，设置 ServletContext 数据；
        // 然后我们用B浏览器访问这个项目的 Demo04 页面，我们可以发现，我们能获取 Demo03 页面中设置的键值对。
        // 不是同一次请求，可以访问公共资源，这就说明 ServletContext 的作用时间长，作用范围大。【所有用户都可以共享数据】【可以认为：ServletContext 的生存周期是服务器启动到结束】
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}


/*

## ServletContext对象：
        1. 概念：代表整个web应用，可以和程序的容器(服务器)来通信
        2. 获取：
            1. 通过request对象获取
                request.getServletContext();
        2. 通过HttpServlet获取  getServletContext()在GenericServlet里面有，而我们的HttpServlet又继承GenericServlet，我们又继承HttpServlet，所以我们可以通过 【this】对象访问 getServletContext()
        this.getServletContext();
        3. 功能：
            1. 获取MIME类型：
            * MIME类型:在互联网通信过程中定义的一种文件数据类型
            * 格式： 大类型/小类型   text/html		image/jpeg

            * 获取：String getMimeType(String file)  ServletContext接口中的抽象方法

                【====】tomcat服务器源码，conf/web.xml是所有项目的web.xml的爹,里面存储了很多Mime的对应关系，我们这个方法，getMimeType()读取文件名，然后截取后缀名，然后去conf/web.xml里面查找
                对应的 Mime 类型。返回
        2. 域对象：共享数据
            1. setAttribute(String name,Object value)
            2. getAttribute(String name)
            3. removeAttribute(String name)

        * ServletContext对象范围：所有用户所有请求的数据
        3. 获取文件的真实(服务器)路径
            1. 方法：String getRealPath(String path)
            String b = context.getRealPath("/b.txt");//web目录下资源访问
            System.out.println(b);

            String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
            System.out.println(c);

            String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
            System.out.println(a);

*/
