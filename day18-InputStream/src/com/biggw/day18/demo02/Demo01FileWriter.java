package com.biggw.day18.demo02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gw
 * @date 2019/11/9 0009 ���� 20:00
 */

/*
 * �ַ��������ʹ�ò���
 * 1.����FileWriter����,���췽����д���ݵ�Ŀ�ĵ�
 * 2.ʹ��FileWriter�еķ���write(),������д�뵽�ڴ滺������(��һ������Ҫ�����ǽ�֧�ַ�ת��Ϊ�ֽ�)
 * 3.ʹ��FileWriter�еķ���flush(),���ڴ滺����������,ˢ�µ�Ӳ�̵��ļ���
 * 4.�ͷ���Դ(���Ȱ��ڴ滺�����е�����ˢ�µ��ļ���)
 *
 * flush();ˢ�»�����,��������Լ���ʹ��
 * close();��ˢ�»�����,Ȼ��֪ͨϵͳ�ͷ���Դ,�����󲻿����ٱ�ʹ��
 *
 * void write(char ch)
 * void write(char[] chars);
 * abstract void write(char[] chars, int off, int len)
 * void write(String str);д���ַ���
 * void write(String str,int off, int len);д���ַ�����һ����
 *
 * ���к�׷��д,��FileOutputStreamһ��
 *
 * */
public class Demo01FileWriter {
    public static void main(String[] args) throws IOException {
        // 1.
        FileWriter fileWriter = new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo02\\test.txt");
        // write()����,������д���ڴ滺������(���ַ�ת��Ϊ�ֽ�)
        fileWriter.write(97);
        fileWriter.write(98);
        // ʹ��flush()����,���ڴ�������ˢ�µ��ļ���,
        fileWriter.flush();
        // ʹ��close()����,���ڴ�������ˢ�µ��ļ���,
        fileWriter.close();


        FileWriter fileWriter1 = new FileWriter("D:\\code\\Java\\basic_code_new\\day18-InputStream\\src\\com\\biggw\\day18\\demo02\\test1.txt");
        // write()����,������д���ڴ滺������(���ַ�ת��Ϊ�ֽ�)
//        char[] chars = {'4','5'};
//        while(true) {
//            fileWriter1.write(chars);
//        }
        //  ʹ��flush()����,���ڴ�������ˢ�µ��ļ���,
//        fileWriter.flush();
        // ʹ��close()����,���ڴ�������ˢ�µ��ļ���,
//        fileWriter.close();

//        fileWriter1.write('��');
//        fileWriter1.write(new char[]{'��', '��', '!'});
        fileWriter1.write("��ӭ��!");
        fileWriter1.write("������,лл", 1, 5);
        fileWriter1.close();
    }
}
