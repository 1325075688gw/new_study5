package com.biggw.day37.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 12:28
 */

// 第一种配置过滤器的方法,/*表示允许通过任意请求
// @WebFilter("/*")
public class Demo01Filter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 必须有这句话
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
