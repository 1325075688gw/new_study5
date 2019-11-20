package com.biggw.day29.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 14:35
 */
@WebServlet("/demo04RequestRefer")
public class Demo04RequestRefer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // refer 大小写都可以
        String str = request.getHeader("Referer");
        // 直接在浏览器输入localhost:8080/login.html  则refer 为null

        if(str!=null){
            if(str.contains("/day29")){
                System.out.println("播放阿凡达！");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放阿凡达！");
            }
            else{
                System.out.println("非法访问！");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("非法访问！");
            }
        }


    }
}
