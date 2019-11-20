package com.biggw.day18.demo02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 下午 20:00
 */

/*
 * 字符输出流的使用步骤
 * 1.创建FileWriter对象,构造方法中写数据的目的地
 * 2.使用FileWriter中的方法write(),把数据写入到内存缓冲区中(这一步的主要作用是将支字符转换为字节)
 * 3.使用FileWriter中的方法flush(),把内存缓冲区的数据,刷新到硬盘的文件中
 * 4.释放资源(会先把内存缓冲区中的数据刷新到文件中)
 *
 * flush();刷新缓冲区,流对象可以继续使用
 * close();先刷新缓冲区,然后通知系统释放资源,流对象不可以再被使用
 *
 * void write(char ch)
 * void write(char[] chars);
 * abstract void write(char[] chars, int off, int len)
 * void write(String str);写入字符串
 * void write(String str,int off, int len);写入字符串的一部分
 *
 * 换行和追加写,和FileOutputStream一样
 *
 * */
public class Demo01FileWriter {
    public static void main(String[] args) throws IOException {
        // 1.
        FileWriter fileWriter = new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo02\\test.txt");
        // write()方法,把数据写到内存缓冲区中(将字符转换为字节)
        fileWriter.write(97);
        fileWriter.write(98);
        // 使用flush()方法,把内存中数据刷新到文件中,
        fileWriter.flush();
        // 使用close()方法,把内存中数据刷新到文件中,
        fileWriter.close();


        FileWriter fileWriter1 = new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo02\\test1.txt");
        // write()方法,把数据写到内存缓冲区中(将字符转换为字节)
//        char[] chars = {'4','5'};
//        while(true) {
//            fileWriter1.write(chars);
//        }
        //  使用flush()方法,把内存中数据刷新到文件中,
//        fileWriter.flush();
        // 使用close()方法,把内存中数据刷新到文件中,
//        fileWriter.close();

//        fileWriter1.write('你');
//        fileWriter1.write(new char[]{'好', '啊', '!'});
        fileWriter1.write("欢迎您!");
        fileWriter1.write("嘻嘻嘻,谢谢", 1, 5);
        fileWriter1.close();
    }
}
