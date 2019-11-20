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
 * @date 2019/11/19 0019 下午 20:40
 */
@WebServlet("/demo02_ServletContext_Get_Mime")
public class Demo02_ServletContext_Get_Mime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String fileName = "a.html";
        String img = "b.jpg";

        String mimeType = servletContext.getMimeType(fileName);
        String mimeType1 = servletContext.getMimeType(img);

        System.out.println("mimeType = " + mimeType);
        System.out.println("mimeType1 = " + mimeType1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
