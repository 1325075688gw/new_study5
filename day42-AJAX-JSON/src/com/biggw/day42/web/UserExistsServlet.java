package com.biggw.day42.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author gw
 * @date 2019/11/25 0025 下午 19:49
 */
@WebServlet("/userExistsServlet")
public class UserExistsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 我们可以创建一个JavaBean对象，也可以直接使用map来承接返回的json对象，因为JavaBean对象，和map对象，json后一样的
        HashMap<String, Object> map = new HashMap<>();

        String username = request.getParameter("username");
        if("小强".equals(username)){
            map.put("exists", true);
            map.put("msg","用户名已注册");
        }else{
            map.put("exists", false);
            map.put("msg","恭喜您，用户名未注册");
        }

        // 这是一种解决json传输问题的办法
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
