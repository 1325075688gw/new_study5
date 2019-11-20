package com.biggw.day19.demo03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 17:39
 */

/*
 * 该流读取后,就是字符
 *
 * */
public class Demo02ReaderUTF8 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo03\\a.txt"), "utf-8");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            // 该流读取后,就是字符,所以不用char转换类型
            // System.out.print((char)len);
            System.out.print(len);
        }
        inputStreamReader.close();
    }
}
