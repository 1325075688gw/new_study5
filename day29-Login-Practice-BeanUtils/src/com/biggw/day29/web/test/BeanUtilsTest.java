package com.biggw.day29.web.test;

import com.biggw.day29.web.domain.UserBeanTest;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 12:12
 */
public class BeanUtilsTest {
    @Test
    public void testBeanMethod(){

        UserBeanTest userBeanTest = new UserBeanTest();
        try {
            BeanUtils.setProperty(userBeanTest,"hh", "100");
            System.out.println("userBeanTest = " + userBeanTest);

            String hh = BeanUtils.getProperty(userBeanTest, "hh");
            System.out.println("hh = " + hh);


        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

/*

userBeanTest = UserBeanTest{age=100, name='null', sex='null'}
hh = 100

 */
