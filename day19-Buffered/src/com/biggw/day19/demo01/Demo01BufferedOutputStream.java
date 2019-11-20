package com.biggw.day19.demo01;

import java.io.*;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 15:33
 */


/*
 * 字节缓冲流:BufferedOutputStream,BufferedInputStream
 * 字符缓冲流:BufferedWriter,BufferedReader
 *
 * 缓冲流的基本原理,在创建流对象时候,会在内存中创建一个内存缓冲区数组,通过内存缓冲区读写,减少IO系统IO次数,从而提高效率
 *
 * java.io.BufferedOutputStream extends OutputStream
 * 继承父类的方法
 * public void close();  关闭输出流,并释放与此输出流相关的任何系统资源
 * public void flush();  将缓冲区数据写出
 * public void write(byte[] b); 向文件中写入字节数组
 * public void write(98); 也可以就写一个字节
 * public void write(byte[] b, int off, int len);  往文件中,写入off为起始索引,长度为len的字节数组
 * public abstract void write(int b);
 *
 *
 * 构造方法
 * BufferedOutputStream(OutputStream outstream)
 * BufferedOutputStream(OutputStream outstream, int size)，创建指定大小的缓冲区输出流
 *
 * 传递FileOutputStream,缓冲流会给FileOutputStream增加一个缓冲区,提高FileOutputStream的输出效率
 * int size :指定缓冲区的大小，不指定则使用默认
 *
 * 【使用缓冲流进行写数据,那么我们write会将数据先写到缓冲流中,然后我们必须手动调用flush,或者close才能将缓冲区的数据写到硬盘】
 *
 * */
public class Demo01BufferedOutputStream {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo01\\a.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write("你好".getBytes());
        bufferedOutputStream.flush();
//        fileOutputStream.close();

        //只关闭缓冲流就可以了，不用关闭基本流，因为关闭缓冲流就会自动关闭基本流
        bufferedOutputStream.close();

    }
}
