package com.biggw.day19.demo04;

import com.sun.source.tree.NewArrayTree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 22:35
 */
public class Demo03SerializableManyObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("小名", 23));
        people.add(new Person("小龚", 24));
        people.add(new Person("小黄", 25));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo04\\b.txt"));
        objectOutputStream.writeObject(people);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo04\\b.txt"));
        // 反序列化前提,类必须实现Serializable接口,和throws ClassNotFoundException
        Object object = objectInputStream.readObject();
        ArrayList<Person> people1 = (ArrayList<Person>) object;
        objectInputStream.close();

        for (Person person : people1) {
            System.out.println("person = " + person);
        }
    }
}
