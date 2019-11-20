package com.biggw.day29.web.web.servlet;

import com.biggw.day29.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 上午 10:18
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 设置编码
        response.setContentType("text/html;charset=utf-8");

        // 我们知道是User类型，我们可以强制转换
        // 获取request域中共享的User对象
        User user = (User) request.getAttribute("user");

        // 输出
        response.getWriter().write("欢迎您："+user.getUsername());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
