package com.biggw.day30.web.servlet_Encoding.Strearm.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 16:50
 */
@WebServlet("/demo01_OutputStream_Servlet_Two")
public class Demo02_OutputStream_GetBytes_SheZi_UTF8_False_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 没有告诉浏览器用什么编码集来解码，浏览器会使用默认解码规则：【GBK】，所以不能正确解码，会出现【浣犲ソ】
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
