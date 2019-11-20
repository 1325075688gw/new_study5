package com.biggw.day29.web.Request;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 17:10
 */


/*

2. 请求转发：一种在服务器内部的资源跳转方式
    1. 步骤：
        1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
        2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)

    2. 特点：
        1. 浏览器地址栏路径不发生变化
        2. 只能转发到当前服务器内部资源中。 比如这个转发就会失败：
        3. 转发是一次请求  【通过浏览器抓包，我们可以发现浏览器只会发一次请求，转发本质是：内部转发】
            【内部AServlet的请求转发到内部BServlet】



 */
@WebServlet("/demo07RequestGoAnotherServlet")
public class Demo07RequestGoAnotherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/demo03RequestUserAgent");
        requestDispatcher.forward(request,response);
        */

        // 一般我们都采用链式编程 【我们转发是内部的AServlet转发到BServlet，属于服务器内部资源之间的转发，所以我们可以不用加绝对目录】
        // 给服务器使用：不需要加虚拟目录
        //        * 直接写转发路径
        request.getRequestDispatcher("/demo03RequestUserAgent").forward(request,response);

        // 只能在当前服务器的内部资源之间相互转发，不能转发出当前服务器
        request.getRequestDispatcher("htts://baidu.com").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
