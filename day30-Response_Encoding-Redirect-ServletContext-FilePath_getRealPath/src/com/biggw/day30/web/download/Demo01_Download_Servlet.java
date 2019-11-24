package com.biggw.day30.web.download;

import com.biggw.day30.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/20 0020 下午 13:03
 */

@WebServlet("/demo01_Download_Servlet")
public class Demo01_Download_Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 实现从浏览器下载图片

        ServletContext servletContext = this.getServletContext();
        // 1.1 获取图片名字
        String filename = req.getParameter("filename");
        String realPath = servletContext.getRealPath("/img/" + filename);
        // 1.2 获取图片mime类型
        String mimeType = servletContext.getMimeType(filename);


        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = req.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        // 设置响应头
        resp.setContentType(mimeType);
        // 设置响应头
        resp.setHeader("content-disposition","attachment;filename="+filename);

        // 创建图片输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);

        // 2. 创建 response 图片输出流对象
        ServletOutputStream outputStream = resp.getOutputStream();

        // 3.边读边写
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        fileInputStream.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
