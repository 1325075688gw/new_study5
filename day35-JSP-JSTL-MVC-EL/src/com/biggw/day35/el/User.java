package com.biggw.day35.el;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gw
 * @date 2019/11/21 0021 下午 22:44
 */
public class User {
    private String name;
    private int age;
    private Date birthday;


    /**
     * 我们称这种，美化成员变量的过程，为【 逻辑视图 】，以后常用这种
     * @return
     */
    public String getBirStr(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(birthday != null) {
            // 格式化日期
            String newDate = simpleDateFormat.format(birthday);
            // 返回字符串即可
            return newDate;
        }else {
            return "";
        }
    }

    /**
     * 逻辑视图
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User() {
    }

    public User(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.birthday = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }
}
