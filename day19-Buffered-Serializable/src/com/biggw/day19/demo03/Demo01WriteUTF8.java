package com.biggw.day19.demo03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 17:20
 */


/*
 * java.io.OutputStreamWriter extends Writer
 * 将指定的字符按照指定的编码规则写入到文件中
 *
 * 构造方法:
 *      OutputStreamWriter(OutputStream out)  使用默认字符集
 *      OutputStreamWriter(OutputStream out, String charSetName) 使用指定字符集
 *
 *
 *      OutputStream out : new FileOutputStream("xxx")
 *      String charSetName:不区分大小写,utf-8和UTF-8都可以
 *
 *
 * */
public class Demo01WriteUTF8 {
    public static void main(String[] args) throws IOException {
        // 默认就是IDEA,读写的编码规则都是utf8
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo03\\a.txt"), "utf-8");
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}
