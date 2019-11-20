package com.biggw.day24.tranactsion;

import com.biggw.day24.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 19:09
 */
public class JDBCTranactionWrong {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            connection = JDBCUtils.getConnection();

            ps1 = connection.prepareStatement("update info set salary = ? where id = ?");
            ps2 = connection.prepareStatement("update info set salary = ? where id = ?");
            ps1.setDouble(1,500);
            ps1.setInt(2,1);
            ps2.setDouble(1,1500);
            ps2.setInt(2,2);

            ps1.executeUpdate();
            // 制造异常
            int res = 1/0;

            ps2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(ps1, connection);
            JDBCUtils.close(ps2,connection);
        }

    }
}
