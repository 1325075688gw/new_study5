package com.biggw.day30.web.servlet_Encoding.Reader_And_Writer.Response_Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 15:39
 */

/*		2. 服务器输出字符数据到浏览器
                * 步骤：
                1. 获取字符输出流
                2. 输出数据

                * 注意：
                * 乱码问题：
                1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
                2. 设置该流的默认编码
                3. 告诉浏览器响应体使用的编码

                //简单的形式，设置编码，是在获取流之前设置
                response.setContentType("text/html;charset=utf-8");

 */

// 下面三个write都会执行
// response一次响应后就自动销毁，同时他创建的流对象，也会自动关闭，又因为PrintWriter不需要flush，所以数据自然就会被写出去

@WebServlet("/demo01_Writer_Encoding_Servlet")
public class Demo01_Writer_Encoding_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 方式一：获取流对象之前，将流的默认编码 ISO-8859-1 设置为 GBK（gb2312）：
        response.setCharacterEncoding("GBK");
        response.getWriter().write("我是通过设置流传输的默认编码来解决：编码问题");

        // 方式二：通过设置响应头的 content-type 设置【流的默认编码】和【浏览器默认的解码】方式，
        // 设置响应头时候，可以忽略大小写:默认是大写 Content-Type: text/html;charset=utf-8 【设置好后，我们流的默认编码方式就变成了utf-8,同时浏览器非常听话，解析响应头后就乖乖的用我们规定的方式解码】
        response.setHeader("content-type","text/html;charset=utf-16");
        response.getWriter().write("我是通过设置响应头来要求浏览器以流编码方式进行编码来解决：编码问题");

        // 方式三：方式2的升级版，【书写更简单】，我们也同时是指流的默认编码方式和浏览器的默认解码方式。这样我们可以随便选择任何编码字符集了（只要存在）
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("我是方式2的升级版，");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

/**
 *
 * 我们先了解一下：编码和解码如果是同一套编码规则，那么就能成功编解码
 *
 * 1.我们的respone对象是tomcat包装生成的，然后提取信息返回给浏览器
 * 2.tomcat是纯 Java 写的，也就是外国人写的，默认发送到浏览器的数据采用 ISO-8859-1 编码
 * 3.我们浏览器的默认解码方式，一般是跟随系统的，我们是中国的 Windows 系统，所以，我们浏览器使用的就是 GBK（或者gb2312:gbk的扩展编码）
 * 4.所以当我们将文本以 IOS-8859-1 编码成字节流对象后，发送到浏览器端，GBK（gb2312）不能正常解码，所以会出现乱码
 *
 * 解决：
 * 1.我们需要将我们字符转为字节流的编码设置为 GBK（gb2312），然后浏览器就能正确解析
 *         response.setCharacterEncoding("GBK");
 *         response.getWriter().write("我是通过设置流传输的默认编码来解决：编码问题");
 *
 * 2.通过设置响应头的 content-type 设置【流的默认编码】和【浏览器默认的解码】方式，
 *         response.setHeader("content-type","text/html;charset=utf-16");
 *         response.getWriter().write("我是通过设置响应头来要求浏览器以流编码方式进行编码来解决：编码问题");
 *
 * 3.方式2的升级版，【书写更简单】，我们也同时是指流的默认编码方式和浏览器的默认解码方式。这样我们可以随便选择任何编码字符集了（只要存在）
 *         response.setContentType("text/html;charset=utf-8");
 *         response.getWriter().write("我是方式2的升级版，");
 *
 */
