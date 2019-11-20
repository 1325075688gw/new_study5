
package com.biggw.day25.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 21:57
 */
public class JdbcC3p0Utils {
    private static DataSource dataSource;

    static {
        // ComboPooledDataSource 是继承DataSource,所以这儿用了多态
        dataSource = new ComboPooledDataSource();
    }


    // 获取连接池中的一个对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 释放资源
    public static void close(Statement statement, Connection connection){
        /**
         if(statement!=null){
         try {
         statement.close();
         } catch (SQLException e) {
         e.printStackTrace();
         }
         }
         if(connection!=null){
         try {
         connection.close();
         } catch (SQLException e) {
         e.printStackTrace();
         }
         }
         */

        // 利用代码复用
        close(null, statement, connection);

    }


    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet!=null){
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
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // 返回一个连接池
    public static DataSource getDataSource(){
        return dataSource;
    }
}

