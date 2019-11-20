package com.biggw.day20.demo03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author gw
 * @date 2019/11/11 0011 下午 19:23
 */

/*
 *
 *
 *
 * */
public class TCPBSever {
    public static void main(String[] args) throws IOException {
        // 创建服务器SeverSocket,并指定端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            // 使用accept()方法获取到请求的客服端对象(浏览器)
            Socket accept = serverSocket.accept();

            // 浏览器解析器渲染html页面时候,如果发现页面中图片,则浏览器会重新开启一个线程,读取服务器的图片,所以我们服务器就需要一直处于监听状态,客服端请求一次,就返回一次


            InputStream inputStream = accept.getInputStream();
            // 网络传输的都是字节流,我们需要转换为字符流,显示

            // 缓冲流和转换流和输入流混用【重要】 BufferedReader特有方法:readLine(),如果没有数据了,读到的是null,而不是-1
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // 用字符缓冲流读取
            int len = 0;
            String line;
            char[] chars = new char[1024];
            // 将读取到的内容存到这里面
            String[] strings = new String[1024];
            int count = 0;
            line = bufferedReader.readLine();
            String[] arr = line.split(" ");
            String htmlPath = arr[1].substring(1);
            System.out.println("hrmlPath = " + htmlPath);

            /*
            while ((line = bufferedReader.readLine()) != null) {
                strings[count] = line;
                System.out.println(line);
            }
             */

            // 用网络字节输入流读取
            /*
            byte[] bytes = new byte[1024];
            while((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
             */

            // 用转换流读取
            /*
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            while((len = inputStreamReader.read(chars))!=-1){
                System.out.print(new String(chars,0,len));
            }
             */

            // 取出第一行,进行地址切分
            String firstLine = strings[0];
            // 按照空格进行切分
            /*
            String[] arr = firstLine.split(" ");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i+":" + arr[i]);
            }
             */

            // 切出路径
            // String htmlPath = arr[1].substring(1);

            // 返回HTTP协议响应头,固定写法
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
            outputStream.write("Content-Type:text/html\r\n".getBytes());
            // 必须写入空行,否则浏览器不解析
            outputStream.write("\r\n".getBytes());

            // 写入想要返回的信息
            // outputStream.write("你好啊".getBytes());
            FileInputStream fileInputStream = new FileInputStream(htmlPath);

            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,len);
            }
            // 释放资源
            fileInputStream.close();
            accept.close();
        }
        // http://127.0.0.1:8888/day20-Net/src/com/biggw/day20/demo03/web/index.html
//        D:\code\Java\basic_code_new\day20-Net\src\com\biggw\day20\demo03\web\index.html
    }
}
