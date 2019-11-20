package com.biggw.day18.demo04;

import java.util.Properties;
import java.util.Set;

/**
 * @author gw
 * @date 2019/11/10 0010 ���� 14:19
 */


/*
 * java.util.Properties extends Hashtab<k,v> implements Map<k,v>
 * Properties��ʾһ���־õ����Լ���,Propeties���Ա��浽���л�����м���
 * Properties��Ψһһ����IO�����ϵļ���
 *       Properties�е�store()����,���԰Ѽ�������ʱ���ݳ־û���Ӳ���д洢
 *       Properties�е�Load()����,���Խ�Ӳ�����ļ�(��ֵ��),��ȡ��������ʹ��
 * Properties�м�ֵ�����ַ���
 *
 *
 * Properties�����еķ���.
 *       Object setProperty(String key, String value) ����Hashtab�е�put����
 *       String getProperty(String key)  �൱��Map�е�get(key)
 *       Set<String> stringPropertyNames() �൱��Map�е�keySet()����
 * */
public class Demo01Properties {

    public static void main(String[] args) {
        // ���ǲ���ָ������,��ΪĬ�ϼ�ֵ�����ַ���
        Properties properties = new Properties();
        properties.setProperty("������", "23");
        properties.setProperty("������", "33");
        properties.setProperty("���ܰ�", "43");

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            System.out.println("string + \" \" + properties.getProperty(string) = " + string + " " + properties.getProperty(string));
        }

    }
}
