package com.biggw.day18.demo03;

import java.io.*;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 13:28
 */


/*
 * JDK7新特性:
 * 我们将定义语句放到try()括号中,多个变量用分号分割
 * try后面的{}执行完后,会自动释放资源
 *
 *
 * */
public class JDK7FIle {
    public static void main(String[] args) throws IOException{
        try (FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\hello.png");
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo03\\hello1.png")
             ;
        ) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

        JDK9();
    }


    // JDK9特性
    public static void JDK9() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\hello.png");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo03\\hello11.png");
        try (fileInputStream;fileOutputStream) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }
}
