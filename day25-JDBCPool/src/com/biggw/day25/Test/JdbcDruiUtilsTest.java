package com.biggw.day25.Test;

import com.biggw.day25.utils.JdbcDruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 21:55
 */
public class JdbcDruiUtilsTest {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = JdbcDruidUtils.getConnection();
            System.out.println("connection = " + connection);

            ps = connection.prepareStatement("insert into info values (null,?,?)");
            ps.setString(1, "大灰狼");
            ps.setDouble(2, 5000);

            int count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDruidUtils.close(ps, connection);
        }
    }
}
