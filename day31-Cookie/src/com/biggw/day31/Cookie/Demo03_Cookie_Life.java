package com.biggw.day31.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/20 0020 下午 16:21
 */
@WebServlet("/Demo03_Cookie_Life")
public class Demo03_Cookie_Life extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置 多个Cookie
        Cookie cookie1 = new Cookie("name", "小强");
        Cookie cookie2 = new Cookie("sex", "男");
        Cookie cookie3 = new Cookie("home", "重庆");

        cookie1.setMaxAge(300);  // 将 Cookie 保存到硬盘上，保存时间为 300 秒，在这期间，即使浏览器关闭，也不会影响删除硬盘中的 Cookie
        cookie2.setMaxAge(-1);  // 默认配置就是设置为0，保存在内存中，即浏览器关闭的时候删除 Cookie
        cookie3.setMaxAge(0);  // 立刻删除对应 Cookie 【 服务器端想要删除 Cookie 的时候这么做】


        // 将 cookie 添加到 response 返回去
        response.addCookie(cookie1);
        response.addCookie(cookie2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
