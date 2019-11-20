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
 * @date 2019/11/19 0019 下午 20:39
 */
@WebServlet("/demo01_ServletContext_Equal")
public class Demo01_ServletContext_Equal extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext1 = request.getServletContext();
        ServletContext servletContext = this.getServletContext();

        System.out.println("servletContext = " + servletContext);
        System.out.println("servletContext1 = " + servletContext1);

        System.out.println(servletContext==servletContext1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
