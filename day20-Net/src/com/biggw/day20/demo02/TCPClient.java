package com.biggw.day20.demo02;

import java.io.*;
import java.net.Socket;

/**
 * @author gw
 * @date 2019/11/11 0011 上午 0:49
 */

/*
* 从硬盘读取文件，发送到服务器，服务器写到本地文件
*
*
* */

public class TCPClient {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("D:\\code\\Java\\basic_code_new\\day20-Net\\src\\com\\biggw\\day20\\demo02\\hello.png"));
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        // 读取数据，但是没有发送文件终止符
        // outputStream.write("上传成功".getBytes());直接这种，应该最后会默认发送文件终止符
        // 所以我们需要手动对while((len=bfis.read(bytes))!=-1)这种进行添加socket.shutdownOutput();写入文件终止符
        while((len=bfis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        // 客服端必须写socket.shutdownOutput()发送文件结束标记
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes))!=-1) {
            System.out.println("提示消息 " + new String(bytes,0,len));
        }
        bfis.close();
        socket.close();
    }
}
