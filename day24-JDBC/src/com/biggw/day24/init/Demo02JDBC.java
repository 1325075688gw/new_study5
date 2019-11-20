package com.biggw.day24.init;

import java.sql.*;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 14:02
 */

public class Demo02JDBC {
    // DML 返回0

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc1?useSSL=false&serverTimezone=GMT", "root", "123456");
            statement = conn.createStatement();
            String sql = "select * from info;";
            // 最开始指向的第一行的字段名,所以我们需要下移动一行
            resultSet = statement.executeQuery(sql);

            // 游标向下移动一行
            // 判断是否有数据
            // 获取数据,(并循环)
            while(resultSet.next()!=false){
                // 列的编号从1开始, 而不是0开始
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println("id: "+id +"  name: "+name+"  salary: "+salary);
            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet !=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
