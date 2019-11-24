package com.biggw.day36.web.servlet;

import com.biggw.day36.domain.User;
import com.biggw.day36.service.UserService;
import com.biggw.day36.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 18:19
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受待修改id
        String id = request.getParameter("id");

        // 2.调用service查询
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findUserById(id);

        // 3.将user存入request
        request.setAttribute("user",user);

        // 4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
