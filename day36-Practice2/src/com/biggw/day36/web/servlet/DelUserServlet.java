package com.biggw.day36.web.servlet;

import com.biggw.day36.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 18:05
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取所有要删除的 id 【支持批量删除】
        String id = request.getParameter("id");

        // 2.调用service删除
        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUser(id);

        //3.跳转查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
