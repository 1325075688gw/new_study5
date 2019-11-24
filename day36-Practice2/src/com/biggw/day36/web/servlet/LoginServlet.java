package com.biggw.day36.web.servlet;

import com.biggw.day36.domain.User;
import com.biggw.day36.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 16:25
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码（因为是 POST 接受数据）
        request.setCharacterEncoding("utf-8");

        // 2.获取数据
        String verifycode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 2.1 验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); //确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        // 2.2 用户名或密码错误！
        UserServiceImpl userService = new UserServiceImpl();
        User loginUser = userService.login(user);  // loginUser,中保存了很多用户信息，我们将此对象存入到 session 中
        if(loginUser != null){
            // 登陆成功将用户信息存到session中
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            request.setAttribute("login_msg","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
