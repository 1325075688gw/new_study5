package com.biggw.day29.web.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 23:24
 */
public class JdbcUtils {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();

        try {
            properties.load(Objects.requireNonNull(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties")));
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
