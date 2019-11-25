package com.biggw.day19.demo05;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 22:49
 */

/*
 * 输出流，不会抛出IOException异常，会抛出FileNotFoundException
 *
 *
 * */
public class Demo01PrintStream {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = new PrintStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo05\\改变输出位置.txt");
        System.setOut(printStream);
        System.out.println("我是改变打印流输出位置");

        // 使用父类的方法write,那么在查看数据时候会查询编码,
        printStream.write(97); // 查看显示a
        printStream.write("\r\n".getBytes());

        // 使用自己特有方法,查看数据时候,远样输出(并且带有换行)
        printStream.println(4324);
        printStream.println("你好啊");
    }
}
