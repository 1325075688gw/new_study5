package com.biggw.day20.demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author gw
 * @date 2019/11/11 0011 上午 0:58
 */


/*
* outputStream.write("上传成功".getBytes());直接这种，应该最后会默认发送文件终止符
*
*
* */

public class TCPServerForever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];

            File file = new File("D:\\code\\Java\\basic_code_new\\day20-Net\\src\\com\\biggw\\day20\\demo02\\test");
            if(!file.exists()){
                file.mkdirs();
            }
            String name = "biggw"+System.currentTimeMillis()+new Random().nextInt(9999)+".jpg";
            file = new File(file,name);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while((len=inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("上传成功".getBytes());
            outputStream.close();
            fileOutputStream.close();
            accept.close();
        }
        // serverSocket.close();
    }
}
