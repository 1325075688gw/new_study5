package com.biggw.day18.demo04;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 15:13
 */

/*
 * void load(InputStream instraem) 不能读取含中文的键值对
 * void load(Reader reader) 可以读取含有中文的键值对
 *
 *
 * 1.存储键值对的文件,键值对之间的连接符,可以是=,空格,或者其他符号
 * 2.可以使用#注释,#注释的键值对不会被读取进来
 * 3.存储键值对的文件,默认都是字符串,不用再加引号
 *
 * */
public class Demo03PropertyInputFile {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        FileReader fileReader = new FileReader("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo04\\utf.txt");
        properties.load(fileReader);
        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            System.out.println("string+\" \"+properties.getProperty(string) = " + string+" "+properties.getProperty(string));
        }

        System.out.println("======================");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo04\\utf.txt"), "utf-8");
        int len = 0;
        char[] chars = new char[1024];
        while((len=inputStreamReader.read(chars))!=-1){
            // 如果读取的len=inputStreamReader.read(),则len为
            /*
            len = 35
            len = 115
            len = 97
            len = 118
            len = 101
             */

            // 如果读取的是len=inputStreamReader.read(chars) ,则len =65,内容都在chars里面
            System.out.println("len = " + len);

//            System.out.println(len);
            /*
            35
            115
            97
            118
            101
            13
            10
            35
            83
            117
            110
            32
            78
             */

//            【用这种】
//            System.out.println((char)len);
            /*
            #
            s
            a
            v
            e

             */
//            【用这种】
//            System.out.println(new String(chars));
            /*
            #save
            #Sun Nov 10 17:43:08 CST 2019
            你好=33
            姊佹�诲寘=43
            鏃犲欢鏈�=23
             */


//            for (char aChar : chars) {
//                System.out.print(aChar);
//            }

            /*

            #save
            #Sun Nov 10 17:43:08 CST 2019
            你好=33
            姊佹�诲寘=43
            鏃犲欢鏈�=23
             */
        }
        inputStreamReader.close();
    }
}
