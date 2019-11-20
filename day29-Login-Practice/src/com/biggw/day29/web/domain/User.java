package com.biggw.day29.web.domain;

/**
 * @author gw
 * @date 2019/11/18 0018 下午 23:20
 */



/*

domain 一般都放 JavaBean


1. JavaBean：标准的Java类
    1. 要求：
        1. 类必须被public修饰
        2. 必须提供空参的构造器
        3. 成员变量必须使用private修饰
        4. 提供公共setter和getter方法

    2. 概念：
        成员变量：
        属性：setter和getter方法截取后的产物  【属性在大多时候和成员变量是一样的，当然也可以不一样】
            一样：private String username;                             username: 成员变量
                例如：getUsername() --> Username--> username   username：属性

            不一样：private String sex;
                例如：setHh(String sex){
                        this.sex = sex;
                    }
                   这儿的成员变量就是sex
                   属性是hh 【H 大写变小写 h】

 */
public class User {
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
