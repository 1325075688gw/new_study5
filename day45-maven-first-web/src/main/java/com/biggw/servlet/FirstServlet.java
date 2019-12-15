package com.biggw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 20:25
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        resp.setContentType("text/html;charset=utf8");
//        resp.getWriter().write("Hello, Maven!");
        req.getRequestDispatcher("/home.jsp").forward(req, resp);

        System.out.println("Hello, Maven!");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
