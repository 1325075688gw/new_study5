package com.biggw.day24.tranactsion;

import com.biggw.day24.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 19:25
 */


/*
 * Connection对象不仅可以创建sql对象,还可以创建事务对象
 *
 * 1.开启事务:setAutoCommit(boolean autoCommit)
 *      在执行sql之前开启事务
 * 2.提交事务:void commit()
 *      当所有sql执行完毕后回滚
 * 3.回滚事务:void rollback()
 *
 *
 * */
public class JDBCTranactionRight {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            connection = JDBCUtils.getConnection();
            // 默认自动提交事务
            connection.setAutoCommit(false);
            ps1 = connection.prepareStatement("update info set salary = ? where id = ?");
            ps2 = connection.prepareStatement("update info set salary = ? where id = ?");
            ps1.setDouble(1, 500);
            ps1.setInt(2, 1);
            ps2.setDouble(1, 1500);
            ps2.setInt(2, 2);

            ps1.executeUpdate();
            // 制造异常
            int res = 1 / 0;

            ps2.executeUpdate();
            // 提交事务
            connection.commit();

            // 将异常置为最大个,这样好回滚
        } catch (Exception e) {
            try {
                // 在catch里面,第一时间回滚
                // 回滚事务
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps1, connection);
            JDBCUtils.close(ps2, connection);
        }

    }
}


/**
 * 数据库连接池：
 *
 * 标准接口：DataSource
 *
 * 1.获取连接：
 *      Connection getConnection()
 * 2.归还连接：
 *      connection.close() 如果连接是从连接池里面获得的,则调用该方法,则不会关闭连接，而是归还连接
 *
 * 一般我们不需要实现连接池,由数据库厂商来实现
 * 1.C3P0：数据库连接池技术（和hibernate一起发布的，有点老了）
 * 2.Druid：数据库连接池实现技术，由阿里巴巴提供
 */













