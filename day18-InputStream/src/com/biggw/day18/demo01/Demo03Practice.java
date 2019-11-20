package com.biggw.day18.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 下午 17:39
 */
public class Demo03Practice {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\hello.png");

        // 以追加形式写
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\hello1.png", true);

        int len = 0;
        byte[] bytes = new byte[1024];
        // 一次读取多个字节
        while ((len = fileInputStream.read(bytes)) != -1) {
            // 读多少写多少
            fileOutputStream.write(bytes,0,len);
        }

        // 先关闭写,后关闭读(如果写完了,读肯定完了)
        fileOutputStream.close();
        fileInputStream.close();
    }
}
