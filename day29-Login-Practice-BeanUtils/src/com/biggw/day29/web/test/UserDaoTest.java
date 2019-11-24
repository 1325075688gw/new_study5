package com.biggw.day29.web.test;

import com.biggw.day29.web.dao.UserDao;
import com.biggw.day29.web.domain.User;
import org.junit.Test;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 23:43
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        UserDao userDao = new UserDao();
        User user = new User("小强","123456");
        User login = userDao.login(user);
        System.out.println("login = " + login);
    }
}
