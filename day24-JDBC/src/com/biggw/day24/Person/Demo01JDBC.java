package com.biggw.day24.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 14:54
 */
public class Demo01JDBC {

    public static void main(String[] args) {

        List<Person> people = findAll();
        System.out.println(people);


    }

    public static List<Person> findAll(){
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        // 我们在外面尽量用null赋值,而不用new ArrayList<Person>()赋值,因为这条语句不一定会执行成功,所以可以先不在堆中申请内存
        ArrayList<Person> people = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?useSSL=false&serverTimezone=GMT", "root", "123456" );
            statement =  conn.createStatement();
            String sql = "select * from info";
            resultSet =statement.executeQuery(sql);

            people = new ArrayList<>();
            Person person=null;
            // todo: 从下到上的封装
            while(resultSet.next()!=false){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                // 之所以把person对象定义在外面,主要是为了减少栈内存
                person = new Person(id,name,salary);
                people.add(person);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 避免空指针异常
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return people;
    }
}
