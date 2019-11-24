package com.biggw.day30.web.servlet_Encoding.Reader_And_Writer.Request_Read;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 15:35
 */
@WebServlet("/emo01Reader_POST_Encoding")
public class Demo01_Reader_POST_Encoding_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET请求：中文乱码，tomcat已经帮我们解决了
        // POST请求：中文乱码，需要我们自己去解决

        // 即可解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        System.out.println("name = " + name);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
