package com.biggw.day24.test;

import com.biggw.day24.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 16:41
 */
public class JDBCTestUtils2 {
    public static void main(String[] args) {


        System.out.print("请输入用户名：");
        String name = new Scanner(System.in).nextLine();
        System.out.print("请输入密码：");
        String password = new Scanner(System.in).nextLine();
        boolean login = login(name, password);
        String msg =  login ?"登陆成功！" :"登录失败！";
        System.out.println(msg);

    }

    public static boolean login(String name, String password){
        if(name==null || password==null){
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        try {
            connection  = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from user where name='"+name+"' and password='"+password+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement, connection);
        }

        // finally 一般就是用来处理资源的回收,别无它用,所以我们还需要在下面返回return false(因为执行到finally外,一定是执行失败了,所以我们手动return false)
        return false;
    }
}
