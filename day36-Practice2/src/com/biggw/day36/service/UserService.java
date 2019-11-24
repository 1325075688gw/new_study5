package com.biggw.day36.service;

import com.biggw.day36.domain.PageBean;
import com.biggw.day36.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 15:33
 */


/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();


    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存User
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage 当前页码
     * @param rows 每页显示的记录数
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
