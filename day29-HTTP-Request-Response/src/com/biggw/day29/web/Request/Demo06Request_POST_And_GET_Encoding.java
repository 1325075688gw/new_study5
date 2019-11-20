package com.biggw.day29.web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 16:26
 */


/*


    1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
    2. 请求转发：一种在服务器内部的资源跳转方式
    3. 共享数据：
    4. 获取ServletContext：


    1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
        1. 【*】String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
        2. String[] getParameterValues(String name):[多用于复选框] 根据参数名称获取参数值的数组  hobby=xx&hobby=game
        3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        4. 【*】Map<String,String[]> getParameterMap():获取所有参数的map集合， 【可以解决复选框问题】



 */
@WebServlet("/demo06RequestPOSTAndGET")
public class Demo06Request_POST_And_GET_Encoding extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST提交数据时候，乱码解决
        request.setCharacterEncoding("utf-8");


        // 不管是通过 GET 还是 POST 访问，都能通过 request.getParameter("username") 获取参数，比较通用，所以以后我们写
        // 代码，只用写一份，然后调用另一个方法
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 1. 【*】String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
        String username1 = request.getParameter("username");
        System.out.println("username1 = " + username1);

        // 2. String[] getParameterValues(String name):[多用于复选框] 根据参数名称获取参数值的数组  hobby=xx&hobby=game
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("hobbies = " + Arrays.toString(hobbies));

        // 3. Enumeration<String> getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        // 4. 【*】Map<String,String[]> getParameterMap():获取所有参数的map集合， 【可以解决复选框问题】
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String s : keySet) {
            String[] strings = parameterMap.get(s);
            System.out.println(s+": "+Arrays.toString(strings));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        */

        // 通过调用另一个方法，简化代码
        this.doPost(request,response);
    }
}
