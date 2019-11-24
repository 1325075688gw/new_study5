package com.biggw.day30.web.servlet_Encoding.Strearm.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 16:47
 */




@WebServlet("/demo01_OutputStream_Servlet")
public class Demo01_OutputStream_GetBytes_Default_GBK_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好".getBytes()); // getBytes()本方法将返回该操作系统默认的编码格式的字节数组【GBK方式编码】，同时浏览器默认GBK解码，所以可以正确解码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
