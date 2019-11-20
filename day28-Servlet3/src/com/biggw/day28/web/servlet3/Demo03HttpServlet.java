package com.biggw.day28.web.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/17 0017 下午 23:15
 */

// 浏览器访问：http://localhost:8080/servlet3/login.html
@WebServlet("/test3")
public class Demo03HttpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 浏览器输入localhost:8080/login.html
        System.out.println("get...");
    }
}



/*

Servlet是一个接口
    GenericServlet是一个抽象类【继承Servlet】只保留service()抽象方法,强迫我们去实现
        HttpServlet是一个抽象类【继承GenericServlet】 里面没有抽象方法,但是，声明为抽象类只是防止你实例化，因为这个类需要容器去实例化.然后它希望我们去重写里面的doPost(), doGet()方法等

java是提供标准的，比如集合我们就提供一套标准,里面存什么数据,都需要我们自定义类型,比如我们可以存Person对象等,然后调用迭代器方法等.
包括servlet api都是一套标准、规范，然后GenericServlet继承,我们需要实现里面的抽象方法service()方法,然后HttpServlet继承GenericServlet,实现全部方法,
虽然实现了全部方法,但是其实是一个标准,逻辑规范,比如,接收到请求后,提取出HTPP协议版本后,我们提取出URL等,然后执行doGet(),doPost()方法等. 这一切都是规则,他只是帮我们搭建了一套实现流程
具体的方法载体希望我们自己再实现一遍,所以还是定义为抽象类,然后由服务器供应商，比如tomcat、weblogic提供实现。

或者我们自定义实现


 */