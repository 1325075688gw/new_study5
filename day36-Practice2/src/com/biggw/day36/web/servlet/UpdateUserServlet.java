package com.biggw.day36.web.servlet;

import com.biggw.day36.domain.User;
import com.biggw.day36.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

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
 * @date 2019/11/23 0023 下午 18:20
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码
        request.setCharacterEncoding("utf-8");

        // 2. 获取map
        Map<String, String[]> parameterMap = request.getParameterMap();

        // 3. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 4. 调用service修改对象
        UserServiceImpl userService = new UserServiceImpl();
        userService.updateUser(user);

        // 5. 跳转到查询所有的记录的servlet
        // response.sendRedirect(request.getContextPath()+"/userListServlet");
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
