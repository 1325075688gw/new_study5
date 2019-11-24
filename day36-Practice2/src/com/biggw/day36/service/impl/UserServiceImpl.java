package com.biggw.day36.service.impl;

import com.biggw.day36.dao.UserDao;
import com.biggw.day36.dao.impl.UserDaoImpl;
import com.biggw.day36.domain.PageBean;
import com.biggw.day36.domain.User;
import com.biggw.day36.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 15:51
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(String id) {
            userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {

        // 防止空指针异常
        if(ids != null && ids.length >0) {
            for (String id : ids) {
                userDao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int  _currentPage = Integer.parseInt(currentPage);
        int _rows = Integer.parseInt(rows);

        // 异常处理
        if(_currentPage<=0){
            _currentPage = 1;
        }

        // 创建空的 PageBean 对象
        PageBean<User> userPageBean = new PageBean<>();

        // 计算start
        int start = (_currentPage-1)*_rows;

        // 查询 Users
        List<User> users = userDao.findByPage(start, _rows, condition);

        // 查询总记录数
        int totalCount = userDao.findTotalCount(condition);

        // 计算总页面
        int totalPage = (totalCount%_rows) == 0 ? (totalCount/_rows) : (totalCount/_rows)+1;

        // 异常处理
        if(_currentPage>totalPage){
            _currentPage = totalPage;
        }

        // 给 PageBean 设置参数
        userPageBean.setCurrentPage(_currentPage);
        userPageBean.setList(users);
        userPageBean.setRows(_rows);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPage(totalPage);


        return userPageBean;
    }
}
































