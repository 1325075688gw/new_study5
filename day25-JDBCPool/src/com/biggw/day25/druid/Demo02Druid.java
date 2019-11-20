package com.biggw.day25.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 21:16
 */
public class Demo02Druid {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        ClassLoader classLoader = Demo02Druid.class.getClassLoader();

        // 方法一（不推荐）
        // getResource()这个获取的是资源的文件(File),我们还需要将提取出,file的路径然后,自己加载资源
        /**
        URL resource = classLoader.getResource("druid.properties");
        String path = resource.getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        properties.load(bufferedReader);
         */

        // 方法二（推荐）
        // getResourceAsStream()返回的是流对象,我们可以直接作为properties.load()的参数中去
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);

        // 创建数据库连接池：Druid不能自动加载配置文件,所以配置文件的地方我们可以自己指定,然后我们将properties对象穿进去,创建连接池对象
        // 通过工厂来获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取一个连接池对象
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);

    }
}
