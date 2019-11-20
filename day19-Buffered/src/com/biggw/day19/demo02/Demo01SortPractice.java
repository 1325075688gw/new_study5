package com.biggw.day19.demo02;

import java.io.*;
import java.util.HashMap;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 16:28
 */


/*
 * java.io.BufferedReader extends Reader
 *
 * 继承父类的方法
 *      int read() 读取单个字符并返回
 *      int read(char[] chars) 一次读取多个字符,并将读取到的字符存储到字符串
 *      void close() 关闭该流并释放与之相关的所有资源
 *
 * 构造方法：
 *      BufferedReader(Reader in)
 *      BufferedReader(Reader in, int size) 创建指定大小的输入缓冲区的缓冲字符输入流
 *
 * 特有方法：
 *      String readLine() 读取一行文本,
 *          行的终止符号:换行\r,回车\r,换行回车\r\n
 *          返回值,包含该行的字符串内容,不包含任何终止符,如果已经到达末尾,则返回null
 *
 *      newLine():输出换行符
 *
 * */


/*
 * 将文件重新排序
 *
 * */
public class Demo01SortPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo02\\a.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo02\\b.txt"));

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String line;
        ////////////////
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split("\\.");
            // HashMap会按照key自动进行排序
            stringStringHashMap.put(strings[0], strings[1]);
        }

        for (String string : stringStringHashMap.keySet()) {
            String stringBuffer = new String();
            stringBuffer = string + "." + stringStringHashMap.get(string);
            bufferedWriter.write(stringBuffer);
            // 写换行符
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
