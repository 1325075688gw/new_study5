package com.biggw.day25.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 20:33
 */
public class Demo01C3P0 {
    public static void main(String[] args) throws SQLException {

        // 定义配置文件：(只要写正确下面的名字和放对位置, 就会自动加载)
		//     名称： c3p0.properties 或者 c3p0-config.xml
        //     路径：直接将文件放在src目录下即可。


        // 默认配置
        defaultConfig();

        // 命名配置
        nameConfig();

    }

    public static void defaultConfig() throws SQLException {
        // 获取连接池对象
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        // 获取一个连接对象
        Connection connection = cpd.getConnection();
        System.out.println("connection = " + connection);
    }

    public static void nameConfig() throws SQLException {
        ComboPooledDataSource cpd = new ComboPooledDataSource("otherc3p0");
        Connection connection = cpd.getConnection();
        System.out.println("connection = " + connection);
    }
}
