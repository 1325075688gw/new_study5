package com.biggw.day32.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/20 0020 下午 21:32
 */
@WebServlet("/Demo01_Set_Session")
public class Demo01_Set_Session extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("session = " + session);

        Cookie cookie = new Cookie("name", "小强");
        HttpSession session1 = request.getSession();
        System.out.println("session1 = " + session1);

        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
