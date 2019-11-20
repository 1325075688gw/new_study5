package com.biggw.day18.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 ���� 16:43
 */

/*
 * FileInputStream:���ļ������ݶ��뵽�ڴ���ʹ��
 *
 *

 * ���췽��:
 * FileInputStream(String name);  Ŀ�ĵ���һ���ļ���·��
 * FileIntputStream(File file)     Ŀ�ĵ���һ���ļ�
 *
 * ���췽��������:
 *      1.�ᴴ��һ��FileInputStream����
 *      2.�ὫFileInputStream����ָ���췽����Ҫ��ȡ���ļ�
 *
 *
 * public int read(); һ�ζ�ȡһ���ֽ�
 * public int read(byte[]); һ�ζ�ȡbyte���鳤�ȵ��ֽ�,���ض�ȡ��byte�е��ֽ���
 *
 * // ͨ��byte�����ȡ����֮��,���ǿ���ͨ��String�Ĺ��췽������ת��
 * public String(char[] value)��
 * public String(char[] value, int offset, int count)��
 *
 *
 *
 * ��ȡ���ݵ�ԭ��:
 * java����-->JVM-->OS����ϵͳ-->OS���ö�ȡ���ݵĳ���-->��ȡ����,����,����,������������Ǻ�,JVM�����ǽ������,���Ծ����-1
 *
 *
 * */
public class Demo02FileInputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\c.txt");
        fileOutputStream.write("���,Python".getBytes());
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo01\\c.txt");
//        int len = 0;
//        // read(),һ�ζ�ȡһ���ֽ�,��������ļ�ĩβ,����-1
//        while ((len = fileInputStream.read())!=-1){
//            System.out.print((char)len);
//        }


        // һ�㳤����Ϊ1024��������
        byte[] bytes = new byte[1024];
        int len2 = 0;
        while((len2=fileInputStream.read(bytes))!=-1){

            System.out.println(new String(bytes,0,len2));
            // ��������ַ�ʽ,���û����ס1024�ֽڵĲ��ֻ��ÿ������
            System.out.println(new String(bytes));
        }
    }
}
