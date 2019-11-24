package com.biggw.day30.web.servlet_Encoding.Reader_And_Writer.Response_Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 16:09
 */
@WebServlet("/demo01_Writer_Encoding_Servlet_One")
public class Demo01_Writer_Encoding_Servlet_One extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("gbk");
        response.getWriter().write("方式一：我是通过设置流传输的默认编码来解决：编码问题");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
