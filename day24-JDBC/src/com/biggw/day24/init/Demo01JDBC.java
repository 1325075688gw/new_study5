package com.biggw.day24.init;

import java.sql.*;

/**
 * @author gw
 * @date 2019/11/16 0016 上午 10:58
 */
public class Demo01JDBC {

    public static void main(String[] args) {

        // 提升变量作用域,因为最后需要释放资源
        Connection conn = null;
        Statement statement = null;
        try {
            // 1.导入驱动
            // 2.Adds as Library
            // 3.加载驱动,5.1后不用手动加载,因为libs\mysql-connector-java-5.1.37-bin.jar!\META-INF\services\java.sql.Driver已经帮我们加载了
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 4.创建链接对象
            // 默认服务器需要SSL验证,所以我们需要应服务器要求,useSSL=true,然后提供证书;当然了,我们也可以不提供验证,也就不提供证书
            // mysql默认是GMT,所以jdbc也需要一样
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1?useSSL=false&serverTimezone=GMT", "root", "123456");
            // 如果链接本机,且端口号是3306,我们可以简写
//              conn =DriverManager.getConnection("jdbc:mysql:///jdbc1", "root","123456");
            // 5.获取执行sql语句的对象 Statement
            statement = conn.createStatement();
            // 写sql语句
            String sql = "insert into info(name,salary) values('张三','1000'), ('李四','3000')";
            // 也可以
            // String sql2 = "insert into info values('张三','1000'), ('李四','3000')";
            int count = statement.executeUpdate(sql);
            if(count>0) {
                System.out.println("操作成功！");
                System.out.println("受影响的条数：" + count);
            }else {
                System.out.println("操作失败！");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            // 避免空指针异常
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
