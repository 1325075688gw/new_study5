package com.biggw.day30.web.servlet_Redirect;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 14:05
 */

/*

		1. 完成重定向
			* 重定向：资源跳转的方式
			* 代码实现：
				//1. 设置状态码为302
		        response.setStatus(302);
		        //2.设置响应头location
		        response.setHeader("location","/day15/responseDemo2");


		        //简单的重定向方法
		        response.sendRedirect("/day15/responseDemo2");

			* 重定向的特点:redirect
				1. 地址栏发生变化
				2. 重定向可以访问其他站点(服务器)的资源
				3. 重定向是两次请求。不能使用request对象来共享数据
			* 转发的特点：forward
				1. 转发地址栏路径不变
				2. 转发只能访问当前服务器下的资源
				3. 转发是一次请求，可以使用request对象来共享数据

			* forward 和  redirect 区别  【面试常这样提问】

			* 路径写法：(因为使用相对路径老是要判断当前资源和目标资源之间的相对位置，所以不推荐使用，我们以后写JSP，推荐使用绝对路径)
				1. 路径分类
					1. 相对路径：通过相对路径不可以确定唯一资源
						* 如：./index.html
						* 不以/开头，以.开头路径

						* 规则：找到当前资源和目标资源之间的相对位置关系
							* ./：当前目录
							* ../:后退一级目录
					2. 绝对路径：通过绝对路径可以确定唯一资源
						* 如：http://localhost/day15/responseDemo2		/day15/responseDemo2
						* 以/（反斜杠）开头的路径

						* 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出
							* 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)               【重定向：加虚拟目录(项目目录)】
								* 建议动态获取虚拟目录：request.getContextPath()
								* <a> , <form> 重定向...
							* 给服务器使用：不需要加虚拟目录                                 【转发：不用加虚拟目录(项目目录)】
								* 转发路径


 */

@WebServlet("/demo01_Response_Redirect_Servlet")
public class Demo01_Response_Redirect_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("我是第一次访问!");
        
        // 方式一:自己设置响应状态码和响应头
        
        // 1.设置响应状态码 302(临时重定向)
         response.setStatus(302);
        // 2.设置响应头
         response.setHeader("location","/day30/demo01_Redirect_Here_Servlet");
        
        
        // 方式二:简便方式设置重定向 (因为分析方式一的重定向,发现值只需要改动重定向的URL,其他不需要改变,所以简写比较合适)

        //request.setAttribute("age",12); // 因为重定向是两次请求,所以会生成两个request对象,所以不能用request共享数据
        //response.sendRedirect("/day30/demo01_Redirect_Here_Servlet");

        // 通过动态获取虚拟目录 request.getContextPath(): 这样就可以防止我们修改服务器访问目录（虚拟目录）后路径找不到
        response.sendRedirect(request.getContextPath()+"/demo01_Redirect_Here_Servlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
