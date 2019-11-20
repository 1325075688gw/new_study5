package com.biggw.day18.demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 下午 15:22
 */


/*
 * java.io.OutputStream:将内存中的数据写到硬盘中
 * 此抽象类的父类是Java.lang.Object
 * 此抽象类表示的是输出字节流的所有类的超类
 *
 * public void close();  关闭输出流,并释放与此输出流相关的任何系统资源
 * public void flush();  刷新...
 * public void write(byte[] b); 向文件中写入字节数组
 * public void write(98); 也可以就写一个字节
 * public void write(byte[] b, int off, int len);  往文件中,写入off为起始索引,长度为len的字节数组
 * public abstract void write(int b);
 *
 *
 *
 * java.io.FileOutputStream extends OutputStream
 * FileOutputStream:文件字节输出流(将内存中的数据写到硬盘中的文件)
 *
 *
 * 构造方法:
 * FileOutputStream(String name);  目的地是一个文件的路径
 * FileOutputStream(File file)     目的地是一个文件
 *
 * 追加写:
 * FileOutputStream(String name, boolean append)
 * FileOutputStream(File file, boolean append)
 *
 * 写换行符:
 * Windows:\r\n
 * Linux:/n
 * Mac:/r
 *
 * 构造方法的作用:
 *      1.创建一个FileOutputStream对象
 *      2.根据构造方法中的参数,创建或者关联一个文件
 *      3.将FileOutputStream()对象指向创建好的文件
 *
 *
 * 写入数据的原理(内存--->硬盘)
 *      java程序-->JVM-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中
 *
 *
 * 字节输出流的使用步骤
 *      1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
 *      2.调用FileOutputStream对象中的write()方法,将数据写入到文件中
 *      3.释放资源(流使用会占用一定的资源,使用完毕后需要把了流资源清空,提高程序的效率)
 * */
public class Demo01FileOutputStream {
    public static void main(String[] args) throws IOException {

        // 我们写入的是98,写入数据的时候,会将10进制的数据转换为二进制数据,10100011
        // 然后存到硬盘中

        // 当我们用任意记事本打开文件时候,都会查询编码表,把字节转换为字符表示,0-127:查询ASCII编码表,其他数字查询其他编码表


        FileOutputStream fos = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\a.txt");
        fos.write(98);
        fos.close();

        FileOutputStream fos1 = new FileOutputStream(new File("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\b.txt"));
        fos1.write(99);
        fos1.close();

        // 一次写入多个字节
        // 如果第一个字节是正数(0-127),那么显示的时候会查询ASCII表
        // 如果第一个字节是负数,那么第一个字节会和第二个字节组成一个中文显示,查询系统默认编码表(GBK)

        byte[] bytes = {65, 66, 67, 68, 69};
        byte[] bytes1 = {-65, 66, -67, 68, 69}; // 两个汉字
        FileOutputStream fos2 = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\a.txt");
        fos2.write(bytes);
        fos2.write(bytes1);
        fos2.close();

        // public write(byte[], int off, int len); 往文件中,写入off为起始索引,长度为len的字节数组
        FileOutputStream fos3 = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\a.txt");
        byte[] bytes3 = {65, 66, 67, 68, 69};
        fos3.write(bytes3,1,2);
        fos3.close();


        // public write(byte[], int off, int len); 往文件中,写入off为起始索引,长度为len的字节数组
        FileOutputStream fos4 = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\a.txt");
        byte[] bytes4 = "你好".getBytes();
        fos4.write("\r\n".getBytes());
        fos4.write(bytes4);
        fos4.close();
    }
}
