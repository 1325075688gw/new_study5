package com.biggw.day34.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author gw
 * @date 2019/11/21 0021 下午 19:28
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 1. 定义变量
        int width = 300;
        int height = 100;
        Random random = new Random();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        // 生成图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 填充背景色
        g.setColor(Color.gray);
        g.fillRect(0,0,width, height);

        // 画边框
        g.setColor(Color.red);
        g.drawRect(0, 0, width, height);

        // 画干扰线
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(width);
            int i2 = random.nextInt(width);
            int i3 = random.nextInt(height);
            int i4 = random.nextInt(height);
            g.drawLine(i1,i2,i3,i4);
        }

        // 填充验证码
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            stringBuilder.append(c);
            g.setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }

        // 将验证码,保存到session中
        HttpSession session = request.getSession();
        session.setAttribute("checkCode",stringBuilder.toString());

        // 将验证码输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
