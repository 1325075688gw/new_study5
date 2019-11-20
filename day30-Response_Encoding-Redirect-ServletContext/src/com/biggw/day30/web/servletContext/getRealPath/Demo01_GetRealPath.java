package com.biggw.day30.web.servletContext.getRealPath;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/20 0020 下午 12:12
 */

/*

		3. 获取文件的真实(服务器)路径
                1. 方法：String getRealPath(String path)
                String b = context.getRealPath("/b.txt");//web目录下资源访问
                System.out.println(b);

                String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
                System.out.println(c);

                String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
                System.out.println(a);
*/


@WebServlet("/demo01_GetRealPath")
public class Demo01_GetRealPath extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取文件路径  / 表示  /web路径

        // =================================文件存在 src 下===============================
        // 经过编译后，src的文件会变成 字节码（.class） 存放在 /web/WEB-INF/classes下
        // 对于 src 目录下的文件，我们还可以用 getClassLoader 来获取，但是不能获取到其他两个文件，所以局限性较大
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/src.txt");
        System.out.println("realPath = " + realPath);

        // =================================文件存在 web 下===============================
        String realPath1 = servletContext.getRealPath("/web.txt");
        System.out.println("realPath1 = " + realPath1);

        // =================================文件存在 web/WEB-INF 下===============================
        String realPath2 = servletContext.getRealPath("/WEB-INF/web_WEB-INF.txt");
        System.out.println("realPath2 = " + realPath2);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
