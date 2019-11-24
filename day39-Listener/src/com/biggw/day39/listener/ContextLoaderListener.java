package com.biggw.day39.listener; /**
 * @author gw
 * @date 2019/11/24 0024 下午 16:46
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 通过注解配置监听器,不需要添加参数
// @WebListener
public class ContextLoaderListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public ContextLoaderListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------

    /**
     * 监听ServletContext对象时候创建的。ServletContext对象,服务器启动后自动创建。
     *
     * 在服务器启动后自动调用.主要用来加载全局资源
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */


        System.out.println("服务器打开...");

        // 1.获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        // 2.加载资源文件的路径
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        // 3.根据2中的路径获取文件的真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        // 4.加载资源进内存
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(realPath);
            char[] chars = new char[1024];
            int len = 0;
            while((len = fileReader.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("文件加载完毕");

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */

      // 服务器关闭...
        System.out.println("服务器关闭...");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
