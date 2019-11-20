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
@WebServlet("/demo01_Writer_Encoding_Servlet_Three")
public class Demo01_Writer_Encoding_Servlet_Three extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-16");
        response.getWriter().write("方式三：我是方式2的升级版");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
