package com.biggw.day34.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author gw
 * @date 2019/11/21 0021 下午 19:19
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 设置编码
        request.setCharacterEncoding("utf-8");

        // 2. 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userCheckCode = request.getParameter("checkCode");

        // 3. 校验数据
        HttpSession session = request.getSession();
        String checkCode = (String)session.getAttribute("checkCode");
        // 每刷新一次,我们就必须手动清除session中的checkCode
        session.removeAttribute("checkCode");
        boolean codeEqual = checkCode.equalsIgnoreCase(userCheckCode);
        if(codeEqual){
            if ("小强".equals(username) && "123456".equals(password)){
                session.setAttribute("username",username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }
            else {

                // 因为这儿我们用的是转发,所以我们用request域就足够了
                request.setAttribute("login_error","用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("code_error","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
