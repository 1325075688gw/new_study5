package com.biggw.day25.Test;

import com.biggw.day25.utils.JdbcC3p0Utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 22:01
 */
public class JdbcC3p0UtilsTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcC3p0Utils.getConnection();
        System.out.println("connection = " + connection);
    }
}
