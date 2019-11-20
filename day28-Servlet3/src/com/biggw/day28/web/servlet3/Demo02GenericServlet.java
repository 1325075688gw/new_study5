package com.biggw.day28.web.servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/17 0017 下午 23:11
 */

@WebServlet("/test2")
public class Demo02GenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet...");
    }
}

