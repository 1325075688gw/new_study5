package com.biggw.day29.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 14:35
 */
@WebServlet("/demo03RequestUserAgent")
public class Demo03RequestUserAgent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // user-agent 大小写都可以
        String str = request.getHeader("user-agent");
        if(str.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if(str.contains("Firfox")){
            System.out.println("火狐浏览器");
        }
    }
}
