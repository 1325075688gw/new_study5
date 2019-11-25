package com.biggw.day19.demo04;

import java.io.*;

/**
 * @author gw
 * @date 2019/11/10 0010 下午 21:48
 */


/*
 * ObjectOutputStream(OutputStream out)
 * ObjectInputStream(InputStream in)
 *
 * writeObject()
 * readObject()
 *
 *
 * */
public class Demo01Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo04\\a.txt"));
        objectOutputStream.writeObject(new Person("小花", 23));
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\code\\Java\\basic_code_new\\day19-Buffered\\src\\com\\biggw\\day19\\demo04\\a.txt"));
        // 反序列化前提,类必须实现Serializable接口,和throws ClassNotFoundException
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        // 玩一个强转
        Person person = (Person) object;
        System.out.println("person = " + person);
        System.out.println("object = " + object);

    }
}


/*
 * 直接序列化对象进文件的时候,会抛出NotSerializableException异常
 * 为实现该接口的对象将无法进行序列化和反序列化
 *
 * Serializable也叫做标记型接口
 *
 * 我们需要对将要序列化和反序列化的类实现Serializable接口,就会给这个类添加一个标记
 * 当我们进行序列化和反序列化时候,就会检测这个类是否有这个标记
 *      有:就可以序列化和反序列化
 *      没有:就会抛出异常NotSerializableException
 *
 * 可以去看Serializable接口,里面没有任何方法
 *
 * 通俗栗子:去菜市场卖肉,如果肉上有盖章,则说明这肉合格
 *
 *
 *
 * */
class Person implements Serializable {
    private String name;
    private int age;
    // 反序列化，类冲突异常
    // 我们只要保证即使修改类的,序列号也不变就行
    private static final long serialVersionUID = 1L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
