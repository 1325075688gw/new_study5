package com.biggw.day29.web.web.servlet;

import com.biggw.day29.web.dao.UserDao;
import com.biggw.day29.web.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/19 0019 上午 9:58
 */


/*

    9. BeanUtils工具类，简化数据封装
        * 用于封装JavaBean的
        1. JavaBean：标准的Java类
            1. 要求：
                1. 类必须被public修饰
                2. 必须提供空参的构造器
                3. 成员变量必须使用private修饰
                4. 提供公共setter和getter方法
            2. 功能：封装数据


        2. 概念：
            成员变量：
            属性：setter和getter方法截取后的产物
                例如：getUsername() --> Username--> username


        3. 方法：
            1. setProperty()
            2. getProperty()
            3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中【操作的JavaBean中的属性】
                【把map中键当做JavaBean中的属性名称，把map中的值当做JavaBean中的属性的值去封装】

*/


@WebServlet("/loginServlet")
public class LoginServlet_BeanUtils extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");

        // 2.接受外部数据

        // ==================================== 2.1 开始 ============================================
        /* 2.1 自己构建User对象

        我们自己构建比较麻烦,如果我们要获取很多属性的话,代码会很多.所以我们借助工具类:
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);

         */

        // ==================================== 2.1 结束 ============================================


        // ==================================== 2.2 开始 ============================================
        // 2.2 借助 BeanUtils.populate(loginUser,parameterMap) 帮我们快速构建

        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        // 选择阿帕奇的包:import org.apache.commons.beanutils.BeanUtils;
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3.构造用户，去数据库中校验
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        // ================================== 2.2 结束 ===================================

        // 4.判断user，导流
        if (user == null) {
            // 登录失败
            request.getRequestDispatcher("/falseServlet").forward(request, response);
        } else {
            // 存储数据
            // 转发
            request.setAttribute("user", loginUser);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
