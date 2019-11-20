package com.biggw.day18.demo04;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.function.Predicate;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 14:39
 */


/*
 * 可以使用Properties集合中方法,把集合中的临时数据写到文件中
 * void store(OutputStream out, String comments);
 * void store(Writer writer, String comments);
 *
 * 参数:
 *      OutputStream out:字节输出流,不能写入中文
 *      Writer writer:字符输出流,可以写入中文
 *      String comments:注释,用来解释说明保存的文件
 *              注释,不能用中文,因为默认IDEA默认是unicode,而系统编码是GBK
 *              所以,我们一般用空字符串
 * 使用步骤:
 *      1.创建Properties集合对象,添加数据
 *      2.创建字节输出流/字符输出流,构造方法中绑定输出对象
 *      3.使用Properties中的store方法,将集合中的数据写入
 *      4.释放资源
 *
 * */
public class Demo02PropertyOutFile {
    public static void main(String[] args) throws IOException {
        // 我们不用指定泛型,因为默认键值都是字符串
        Properties properties = new Properties();
        properties.setProperty("无延期", "23");
        properties.setProperty("蓝张力", "33");
        properties.setProperty("梁总包", "43");

        FileWriter fileWriter = new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo04\\writer.txt");
        properties.store(fileWriter, "注释,comments");

        properties.store(new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo04\\OuputStream.txt"), "注释,coments");
        fileWriter.close();

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo04\\utf.txt"), "utf-8");
        properties.store(outputStreamWriter, "save");
        outputStreamWriter.close();

    }
}
