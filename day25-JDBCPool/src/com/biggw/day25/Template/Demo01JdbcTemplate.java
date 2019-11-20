package com.biggw.day25.Template;

import com.biggw.day25.utils.JdbcDruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 22:20
 */
public class Demo01JdbcTemplate {
    public static void main(String[] args) {
        // 获取template对象
        // 使用jdbcTemplate我们,我们不需要手动释放资源,也不需要手动创建对象,归还对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtils.getDataSource());
        String sql = "insert into info values (null,?,?)";
        // update():执行DML语句。增、删、改语句
        int count = jdbcTemplate.update(sql, "小黄人",9999);
        System.out.println("count = " + count);
    }
}
