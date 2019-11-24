package com.biggw.day37.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 12:43
 */

/*
		3. 过滤器生命周期方法
			1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
			2. doFilter:每一次请求被拦截资源时，会执行。执行多次
			3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
 */

@WebFilter("/*")
public class Demo02Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.执行过滤器之前
        System.out.println("before filter...");

        // 2.执行放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 3.放行回来后执行
        System.out.println("after filter...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
