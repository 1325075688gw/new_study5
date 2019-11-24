package com.biggw.day29.web.domain;

import java.util.Objects;

/**
 * @author gw
 * @date 2019/11/19 0019 下午 12:13
 */
public class UserBeanTest {
    private int age;
    private String name;
    private String sex;



    public UserBeanTest() {
    }

    @Override
    public String toString() {
        return "UserBeanTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(age, name, sex);
    }

    // 修改 getAge 为 getHh； 修改 setAge 为 setHh，为了测试BeanUtils中的setProperty 和 getProperty
    // 现在属性名：hh
    public int getHh() {
        return age;
    }

    public void setHh(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
