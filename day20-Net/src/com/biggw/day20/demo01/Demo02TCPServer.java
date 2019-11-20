package com.biggw.day20.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gw
 * @date 2019/11/11 0011 上午 0:27
 */
public class Demo02TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("len = " + len);
        System.out.println("bytes = " + new String(bytes,0,len));

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我是服务器".getBytes());
        accept.close();
        serverSocket.close();
    }
}
