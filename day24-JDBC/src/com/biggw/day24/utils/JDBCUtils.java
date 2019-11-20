package com.biggw.day24.utils;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 15:19
 */


/*
*
* 动态获取src文件下的资源的路径
* */

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 随着类的加载而加载,所以我们在这里进行资源文件的读取,然后交给getConnection()使用,所以我们提升变量的作用域
    // 静态代码块只能调用静态变量
    // throws只针对方法,所以静态代码块里面的异常只能捕获
    static {
        try {
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            // getResource()方法可以动态的获取module模块下src目录下的资源的绝对路径
            // 返回的是一个文件对象,对于文件对象,如果我们想要获取绝对路径就直接getPath()
            // resource = file:/D:/code/Java/basic_code_new/out/production/day24-JDBC/jdbc.properties
            URL resource = classLoader.getResource("jdbc.properties");
            // System.out.println("resource = " + resource);
            // 获取绝对路径
            String path = resource.getPath();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            Properties properties = new Properties();
            // properties也是一个文件,对于文件的读取我们用很多中读取方式,但是读进来之后,我们还要进行split(),所以我们推荐读取properties文件时候,就用properties.load()读取
            properties.load(bufferedReader);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            // 注册驱动
            Class.forName(driver);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        // 在上面提升变量的作用域
        // url,user,password 我们是通过读取配置文件来的,但是如果我们想要获取多个链接,那么就需要读取多次url,user,password,但是读取到的内容都是一样的是,所以我们只需要读取一次
        // 这时候我们想到了静态代码块
        return DriverManager.getConnection(url,user,password);
    }




    public static void close(Statement statement, Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
