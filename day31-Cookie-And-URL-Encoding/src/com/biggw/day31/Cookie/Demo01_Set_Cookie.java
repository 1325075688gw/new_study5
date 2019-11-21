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
 * @date 2019/11/20 0020 下午 14:43
 */
@WebServlet("/Demo01_Set_Cookie")
public class Demo01_Set_Cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置 多个Cookie
        Cookie cookie1 = new Cookie("name", "小强");
        Cookie cookie2 = new Cookie("sex", "男");

        // 将 cookie 添加到 response 返回去
        response.addCookie(cookie1);
        response.addCookie(cookie2);

/*        3. cookie能不能存中文？
			* 在tomcat 8 之前 cookie中不能直接存储中文数据。
				* 需要将中文数据转码---一般采用URL编码(%E3)
			* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
