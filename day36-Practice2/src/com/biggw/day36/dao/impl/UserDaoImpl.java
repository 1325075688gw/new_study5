package com.biggw.day36.dao.impl;

import com.biggw.day36.dao.UserDao;
import com.biggw.day36.domain.User;
import com.biggw.day36.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 14:37
 */
public class UserDaoImpl implements UserDao {

    // 获取连接池对象,这儿一定先写 private, 而不是 new
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from User";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            String sql = "select * from User where username = ? and password = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            // 如果查询不到用户，抛出异常，并返回null
            return user;
        }


    }

    @Override
    public boolean add(User user) {
        String sql = "insert into User values(null,?,?,?,?,?,?,null,null)";
        int count = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return count == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from User where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update == 1;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from User where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public boolean update(User user) {
        String sql = "update User set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        int update = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return update == 1;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        /*
        String sql = "select count(*) from User";
        return jdbcTemplate.queryForObject(sql, Integer.class);
         */

        String sql = "select count(*) from User where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);

        ArrayList<Object> params = new ArrayList<>();
        for (String key : condition.keySet()) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                stringBuilder.append(" and "+key+" like ?");
                params.add(" %" + value +"% ");
            }
        }
        sql = stringBuilder.toString();
        return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());


    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {

        /*
        String sql = "select * from User limit ?, ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
         */

        String sql = "select * from User where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        // 定义参数集合
        ArrayList<Object> params = new ArrayList<>();
        for (String key : keySet) {
            // 我们request获取的数据里面有currentPage和rows。我们最后单独拼接，所以我们这儿要排除这两个条件
            // ${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5 然后 form表单数据会提交 name,address,email,所以我们需要过滤
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value!=null && !"".equals(value)){
                stringBuilder.append(" and ").append(key).append(" like ? ");
                params.add(" %" +value+"% ");
            }

        }
        // 添加分页查询
        stringBuilder.append(" limit ?,? ");
        params.add(start);
        params.add(rows);

        sql = stringBuilder.toString();
        System.out.println("sql = " + sql);
        // 可变参数，可以接受数组
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        System.out.println("query = " + query);       
        return query;
    }
}
