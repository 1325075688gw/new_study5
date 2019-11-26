package com.biggw.day44.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author gw
 * @date 2019/11/25 0025 下午 23:23
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 1. 读取配置文件
        InputStream resourceAsStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2.设置jedisPoolConfig
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxIdle")));

        // 3.创建连接池
        // 读取的都是字符串,所以我们需要转换
        jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));

    }

    public static Jedis getJedis(){
        // 4.返回连接对象
        return jedisPool.getResource();
    }

    public static void close(){
        if (jedisPool!=null) {
            jedisPool.close();
        }
    }

}
