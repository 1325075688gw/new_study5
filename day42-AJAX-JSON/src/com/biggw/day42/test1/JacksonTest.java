package com.biggw.day42.test1;

import com.biggw.day42.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author gw
 * @date 2019/11/25 0025 下午 17:19
 */
public class JacksonTest {
    // 2.创建Jackson的核心对象, ObjectMapper
    private ObjectMapper objectMapper = new ObjectMapper();


    // java对象转化为json对象
    @Test
    public void test0() throws IOException {

        // 1.创建Person对象
        Person person = new Person();
        person.setName("小强");
        person.setAge(23);
        person.setGender("男");



        // 3.转化

        /*

            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串

         */

        System.out.println("person = " + person);
        // writeValueAsString,我们可以将其生成的json对象,用到其他地方
        String s = objectMapper.writeValueAsString(person);
        System.out.println("s = " + s);

        /*
        person = Person{name='小强', age=23, gender='男', birthday=null}
        s = {"name":"小强","age":23,"gender":"男","birthday":null}
        */


        // writeValue,将数据写到 D:\code\Java\new_study5\day42-AJAX\src\com\biggw\day42\test1\test1.txt文件中
        objectMapper.writeValue(new File("D:\\code\\Java\\new_study5\\day42-AJAX\\src\\com\\biggw\\day42\\test1\\test1.txt"),person);


        //writeValue.将数据关联到Writer中
        objectMapper.writeValue(new FileWriter(new File("D:\\code\\Java\\new_study5\\day42-AJAX\\src\\com\\biggw\\day42\\test1\\test1.txt"),true),person);

    }

    @Test
    public void test2() throws JsonProcessingException {
        // 1.创建Person对象
        Person person = new Person();
        person.setName("小强");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        System.out.println("new Date() = " + new Date());
        String s = objectMapper.writeValueAsString(person);

        System.out.println("person = " + person);
        System.out.println("s = " + s);


        /*
            new Date() = Mon Nov 25 19:26:37 CST 2019
            person = Person{name='小强', age=23, gender='男', birthday=Mon Nov 25 19:26:37 CST 2019}
            s = {"name":"小强","age":23,"gender":"男","birthday":1574681197620}
        */
    }

    @Test  // @JsonIgnore
    public void test3() throws JsonProcessingException {
        // 1.创建Person对象
        Person person = new Person();
        person.setName("小强");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        System.out.println("new Date() = " + new Date());
        String s = objectMapper.writeValueAsString(person);

        System.out.println("person = " + person);
        System.out.println("s = " + s);

        /*
            new Date() = Mon Nov 25 18:54:43 CST 2019
            person = Person{name='小强', age=23, gender='男', birthday=Mon Nov 25 18:54:43 CST 2019}
            s = {"name":"小强","age":23,"gender":"男"}
        */
    }

    @Test //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")// 按照指定格式格式化
    public void test4() throws JsonProcessingException {
        // 1.创建Person对象
        Person person = new Person();
        person.setName("小强");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        System.out.println("new Date() = " + new Date());
        String s = objectMapper.writeValueAsString(person);

        System.out.println("person = " + person);
        System.out.println("s = " + s);

/*        new Date() = Mon Nov 25 18:56:31 CST 2019
        person = Person{name='小强', age=23, gender='男', birthday=Mon Nov 25 18:56:31 CST 2019}
        s = {"name":"小强","age":23,"gender":"男","birthday":"2019-11-25 10:56:31"}*/

    }


    @Test //json序列化 List数组 对象
    public void test5() throws JsonProcessingException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());


        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        String s = objectMapper.writeValueAsString(ps);
        System.out.println("ps = " + ps);
        System.out.println("s = " + s);

        /*
         ps = [Person{name='张三', age=23, gender='男', birthday=Mon Nov 25 19:25:30 CST 2019}, Person{name='张三', age=23, gender='男', birthday=Mon Nov 25 19:25:30 CST 2019}, Person{name='张三', age=23, gender='男', birthday=Mon Nov 25 19:25:30 CST 2019}]
         s = [{"name":"张三","age":23,"gender":"男","birthday":"2019-11-25 11:25:30"},{"name":"张三","age":23,"gender":"男","birthday":"2019-11-25 11:25:30"},{"name":"张三","age":23,"gender":"男","birthday":"2019-11-25 11:25:30"}]
        */

    }


    @Test //json序列化 Map 对象
    public void test6() throws JsonProcessingException {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        String s = objectMapper.writeValueAsString(map);
        System.out.println("map = " + map);
        System.out.println("s = " + s);

/*        map = {gender=男, name=张三, age=23}
        s = {"gender":"男","name":"张三","age":23}*/
    }

    @Test
    public void test7() throws IOException {
        String json1= "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        Person person = objectMapper.readValue(json1, Person.class);
        System.out.println("person = " + person);

        // person = Person{name='张三', age=23, gender='男', birthday=null}

    }


    @Test
    public void test8() throws IOException {
        String json2= "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2019-11-25 11:25:30\"}";
        Person person = objectMapper.readValue(json2, Person.class);
        System.out.println("person = " + person);

        // 报错

    }

    @Test
    public void test9() throws IOException {
        String json3= "{\"name\":\"小强\",\"age\":23,\"gender\":\"男\",\"birthday\":1574681197620}";
        Person person = objectMapper.readValue(json3, Person.class);
        System.out.println("person = " + person);

        // person = Person{name='小强', age=23, gender='男', birthday=Mon Nov 25 19:26:37 CST 2019}
    }
}
