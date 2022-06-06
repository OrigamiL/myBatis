package com.weifang.pojo;

import java.sql.Date;

/**
 * @Program: myBatis
 * @ClassName: User
 * @Version: 1.0
 * @Description: user类
 * @Author: zhezhi
 * @Create-Date: 2022-06-06 17:35
 **/

public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private Integer sex;
    private String address;

    public User() {
    }

    public User(String username, Date birthday, Integer sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public User(Integer id, String username, Date birthday, Integer sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return (sex==1?"男":"女");
    }

    public void setSex(String sex) {
        this.sex = ("男".equals(sex)?1:2);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + (sex==1?"男":"女") +
                ", address='" + address + '\'' +
                '}';
    }
}
