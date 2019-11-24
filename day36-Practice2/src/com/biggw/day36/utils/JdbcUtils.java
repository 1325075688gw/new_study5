package com.biggw.day36.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 14:38
 */
public class JdbcUtils {
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("driud.properties");
            properties.load(inputStream);

            // 初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取单个连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    // 获取连接池对象
    public static DataSource getDataSource(){
        return dataSource;
    }



}
