package com.biggw.day18.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 下午 16:43
 */

/*
 * FileInputStream:将文件中数据读入到内存中使用
 *
 *

 * 构造方法:
 * FileInputStream(String name);  目的地是一个文件的路径
 * FileIntputStream(File file)     目的地是一个文件
 *
 * 构造方法的作用:
 *      1.会创建一个FileInputStream对象
 *      2.会将FileInputStream对象指向构造方法中要读取的文件
 *
 *
 * public int read(); 一次读取一个字节
 * public int read(byte[]); 一次读取byte数组长度的字节,返回读取到byte中的字节数
 *
 * // 通过byte数组读取出来之后,我们可以通过String的构造方法进行转换
 * public String(char[] value)；
 * public String(char[] value, int offset, int count)；
 *
 *
 *
 * 读取数据的原理:
 * java程序-->JVM-->OS操作系统-->OS调用读取数据的程序-->读取数据,返回,解码,当读到结束标记后,JVM发现是结束标记,所以就输出-1
 *
 *
 * */
public class Demo02FileInputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\c.txt");
        fileOutputStream.write("你好,Python".getBytes());
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\c.txt");
//        int len = 0;
//        // read(),一次读取一个字节,如果读到文件末尾,返回-1
//        while ((len = fileInputStream.read())!=-1){
//            System.out.print((char)len);
//        }


        // 一般长度设为1024的整数倍
        byte[] bytes = new byte[1024];
        int len2 = 0;
        while((len2=fileInputStream.read(bytes))!=-1){

            System.out.println(new String(bytes,0,len2));
            // 如果用这种方式,最后没有瞒住1024字节的部分会用空来填充
            System.out.println(new String(bytes));
        }
    }
}
