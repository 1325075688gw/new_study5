package com.biggw.day36.web.filter;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/24 0024 下午 15:48
 */

// 敏感词过滤器

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private List<String> list = new ArrayList<>();


    // 加载资源,且只加载一次,服务器启动,就会执行,而不是第一次访问才执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            // 1.获取servletContext
            ServletContext servletContext = filterConfig.getServletContext();

            // 2.servletContext中调用getRealPath()
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词.txt");

            //todo 3.BufferedReader 读取本地文件，默认按照gbk编码解码
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));

            // 4.读取文件
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();

            System.out.println(list);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 我们现在要修改request对象中的getParameter()方法返回的才参数


        ServletRequest proxy_request = (ServletRequest)Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("getParameter".equals(method.getName())){
                    // 我们这儿使用代理模式,修改函数的返回值,这样当返回敏感词时候,我们就对它进行拦截修改
                    String value = (String) method.invoke(servletRequest, args);
                    for (String word : list) {
                        if(value.contains(word)){
                            // 将value里面的word替换为***
                            value = value.replaceAll(word, "***");
                        }
                    }
                    return value;
                }
                else {
                    return method.invoke(servletRequest,args);
                }
            }
        });

        filterChain.doFilter(proxy_request,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
