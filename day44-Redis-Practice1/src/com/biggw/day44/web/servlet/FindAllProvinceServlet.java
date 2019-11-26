package com.biggw.day44.web.servlet;

import com.biggw.day44.domain.Province;
import com.biggw.day44.service.ProvinceService;
import com.biggw.day44.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:55
 */
@WebServlet("/findAllProvinceServlet")
public class FindAllProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.声明ProvinceService
        ProvinceService provinceService = new ProvinceServiceImpl();

        // 2.获取查询结果
        List<Province> provinces = provinceService.findAll();

        // 3.json序列化
        ObjectMapper objectMapper = new ObjectMapper();
        String values = objectMapper.writeValueAsString(provinces);

        // test：打印结果
        System.out.println("values = " + values);

        // 4.设置响应头
        response.setContentType("application/json;charset=utf-8");

        // 5.响应数据
        response.getWriter().write(values);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
