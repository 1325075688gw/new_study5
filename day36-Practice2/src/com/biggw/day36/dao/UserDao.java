package com.biggw.day36.dao;

import com.biggw.day36.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 14:26
 */
public interface UserDao {

    // 查找所有用户
    public List<User> findAll();

    // 根据用户名和密码查找用户
    public User findUserByUsernameAndPassword(String username, String password);

    // 添加用户
    boolean add(User user);

    // 删除用户
    boolean delete(int id);

    // 根据 id 查找用户
    User findUserById(int id);

    //更新用户信息
    boolean update(User user);

    // 查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    // 分页查询每页记录
    List<User> findByPage(int start, int rows, Map<String,String[]> condition);

}
