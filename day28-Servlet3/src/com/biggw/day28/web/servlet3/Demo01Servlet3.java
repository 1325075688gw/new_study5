
package com.biggw.day28.web.servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/17 0017 下午 20:52
 */



/*

        web.xml里面的核心代码:就是将资源路径【4】和全类名【2】关联起来，所以我们注解主要关注urlPatterns【相当于资源路径】,然后注解都写在了全类名上面了，所以会自动识别全类名，然后进行关联

        <servlet>
1.          <servlet-name>Demo01Servlet1</servlet-name>
2.          <servlet-class>com.biggw.day27.web.servlet.Demo01Servlet</servlet-class>
        </servlet>

        <servlet-mapping>
3.          <servlet-name>Demo01Servlet1</servlet-name>
4.          <url-pattern>/test</url-pattern>
        </servlet-mapping>


*/

// 浏览器访问路径： http://localhost:8080/servlet3/test


// 简单写法：@WebServlet("/servlet3")
// 要加斜杠
@WebServlet(urlPatterns={"/test1"})
public class Demo01Servlet3 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello, Servlet3.0 !");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}