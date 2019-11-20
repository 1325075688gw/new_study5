package com.biggw.day27.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/17 0017 下午 19:24
 */


/*
 * servlet一般放在web下面
 *
 * */
public class Demo01Servlet implements Servlet {

    /**
     * 在第一次访问servlet时候才会执行
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 每次访问servlet都会执行该方法。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,Tomcat!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 正常关闭servlet时候会执行此方法，暴力关闭，不会执行此方法
     */
    @Override
    public void destroy() {
        System.out.println("close...");
    }
}
