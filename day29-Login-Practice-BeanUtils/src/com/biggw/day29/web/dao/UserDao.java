package com.biggw.day29.web.dao;

import com.biggw.day29.web.domain.User;
import com.biggw.day29.web.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 23:22
 */
public class UserDao {

    public JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    public UserDao() {
    }

    public User login(User loginUser){
        try {
            String sql = "select * from User where username = ? and password = ?";
/*            List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),
                     user.getUsername(),
                    user.getPassword());
            return query.get(0);*/


            User user= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            // 一般我们会在这记录进日志，后面再学
            e.printStackTrace();
            return null;
        }
    }
}
