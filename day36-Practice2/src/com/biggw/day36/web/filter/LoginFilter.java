package com.biggw.day36.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 13:42
 */

/*
通过request，我们可以获取，浏览器请求的URI
5. (*)获取请求URI：/day14/demo1    [做权限控制的时候,会用到这些方法]
						* String getRequestURI():		/day14/demo1
						* StringBuffer getRequestURL()  :http://localhost/day14/demo1

						* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
						* URI：统一资源标识符 : /day14/demo1					共和国
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 1.ServletRequest是HttpServletRequest的父接口，里面没有实现request，所以我们想要获取request，我们先强制转化类型
        HttpServletRequest request = (HttpServletRequest) req;

        // 2.获取URI, 【 requestURI 】
        String URI = request.getRequestURI();

        // 3.我们将登陆相关资源直接放行掉，因为我们就是因为没有登陆，才来访问登陆页面，但是你把登陆页面拦截了，那还怎么访问登陆页面
        // 我们也要讲 css,js 等资源放行，不然登陆页面越来越丑
        if(URI.contains("/login.jsp") || URI.contains("/loginServlet") || URI.contains("/checkCodeServlet")|| URI.contains("/css/") || URI.contains("/fonts/") || URI.contains("/js/"))
        {
            chain.doFilter(req,resp);
        }
        else {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") != null){
                chain.doFilter(req, resp);
            }else{
                session.setAttribute("login_msg","请登陆！");
                session.setAttribute("URI",URI);
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
