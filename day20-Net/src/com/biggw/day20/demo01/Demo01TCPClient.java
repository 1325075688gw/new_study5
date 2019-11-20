package com.biggw.day20.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author gw
 * @date 2019/11/11 0011 上午 0:12
 */


/*
 * Socket(String host, int port)
 *
 * */
public class Demo01TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        os.write("你好".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("len = " + len);
        System.out.println("bytes = " + new String(bytes,0,len));
        socket.close();
    }
}
