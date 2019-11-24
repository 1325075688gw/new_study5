package com.biggw.day36.web.servlet;

import com.biggw.day36.domain.PageBean;
import com.biggw.day36.domain.User;
import com.biggw.day36.service.UserService;
import com.biggw.day36.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Condition;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 20:53
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");

        // 2.获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        // 3.异常判断
        if(currentPage==null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "5";
        }

        // 4.获取参数查询条件
        Map<String, String[]> condition = request.getParameterMap();

        // 5.查询
        UserServiceImpl userService = new UserServiceImpl();
        PageBean<User> userByPage = userService.findUserByPage(currentPage, rows, condition);

        // 6.转发
        request.setAttribute("pb",userByPage);
        request.setAttribute("condition",condition);//将查询条件存入request,方便数据回显
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
