package com.biggw.day24.test;

import com.biggw.day24.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 17:23
 */


/**
 * TODO:
 * PreparedStatement对象他的执行方法
 *      execute:特能执行CURD中的任意一种语句。它的返回值是一个boolean类型，表示有没有结果集，如果有结果集，返回true。否则返回false
 *      executeUpdate：它只能执行CUD语句，查询语句无法执行。会影响数据库中行数
 *      executeQuery：它只能执行selecty语句，无法执行增删改。执行结果封装到ResultSet对象
 *
 *      MyBatis，每次都是执行execute，然后，判断有没有结果集，如果有xxx
 */

/**
 *
 * preparedStatement = connection.prepareStatement("select * from user where name = ? and password =?");
 * 使用？作为填充符,
 * 给？赋值
 * 执行sql语句（选择不带参数的执行方式） resultSet = preparedStatement.executeQuery();
 *
 */
public class JDBCTestUtils2SQLNotZhuRu {
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection  = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from user where name = ? and password =?");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

        // finally 一般就是用来处理资源的回收,别无它用,所以我们还需要在下面返回return false(因为执行到finally外,一定是执行失败了,所以我们手动return false)
        return false;
    }
}


