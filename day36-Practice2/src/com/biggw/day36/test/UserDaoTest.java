package com.biggw.day36.test;

import com.biggw.day36.dao.UserDao;
import com.biggw.day36.dao.impl.UserDaoImpl;
import com.biggw.day36.domain.User;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/23 0023 下午 22:51
 */
public class UserDaoTest {
    private UserDao userDao =  new UserDaoImpl();

    @Test
    public void testfindByPage(){
        Map<String, String[]> condition = new HashMap<>();
        String[] arr = {"欧化"};
        condition.put("name",arr);
        List<User> byPage = userDao.findByPage(0, 3, condition);
        System.out.println("byPage = " + byPage);

    }

}
