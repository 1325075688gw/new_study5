package com.biggw.day29.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 22:20
 */


/*

    3. 共享数据：
    * 域对象：一个有作用范围的对象，可以在范围内共享数据
    * request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
    * 方法：
        1. void setAttribute(String name,Object obj):存储数据
        2. Object getAttitude(String name):通过键获取值
        3. void removeAttribute(String name):通过键移除键值对

 */




@WebServlet("/demo08RequestShareData")
public class Demo08RequestShareData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setAttribute("name","小强");
        // 转发
        request.getRequestDispatcher("/demo03RequestUserAgent").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
