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
 * @date 2019/11/19 0019 下午 16:53
 */
@WebServlet("/demo02_OutputStream_GetBytes_SheZi_UTF8_Right_Servlet")
public class Demo02_OutputStream_GetBytes_SheZi_UTF8_Right_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 告诉浏览器以 utf-8 编码集规则，进行解码，可以正确解码
        response.setContentType("text/html;charset=utf-8");

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好".getBytes(StandardCharsets.UTF_8));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
