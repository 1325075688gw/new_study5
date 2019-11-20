package com.biggw.day24.test;

import com.biggw.day24.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 16:02
 */
public class JDBCTestUtils {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "update info set salary = 9998 where id = 1";
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("受影响的行数： "+ count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }
    }
}
