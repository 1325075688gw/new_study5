package com.biggw.day30.web.erWeiMa;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 19:23
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 300;
        int height = 100;
        Random random = new Random();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 填充背景色
        g.fillRect(0,0,width,height);

        // 画边框
        g.setColor(Color.RED);
        g.drawRect(0,0,width-1, height-1);

        // 画干扰线
        g.setColor(Color.GREEN);
        for (int i = 1; i <= 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            g.drawLine(x1,x2,y1,y2);
        }

        // 画随机字母
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        g.setColor(Color.RED);
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            g.drawString(str.charAt(index)+"",i*width/5,height/2);
        }


        // 输出图片到页面展示
        ImageIO.write(image,"jpg", response.getOutputStream());



        System.out.println("ggggggggggggggggg");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
