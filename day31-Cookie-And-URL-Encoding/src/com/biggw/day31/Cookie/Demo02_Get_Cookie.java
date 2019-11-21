package com.biggw.day31.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author gw
 * @date 2019/11/20 0020 下午 14:45
 */
@WebServlet("/Demo02_Get_Cookie")
public class Demo02_Get_Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            System.out.println("cookie没有");
        }
        else{
            for (Cookie cookie : cookies) {
                System.out.print(cookie.getName()+"       ");
                System.out.println(cookie.getValue());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
