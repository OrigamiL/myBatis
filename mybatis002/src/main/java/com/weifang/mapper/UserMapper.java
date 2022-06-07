package com.weifang.mapper;

import com.weifang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户信息
    List<User> getAll();
    //根据用户id查询用户信息
    User getById(int id);
    //根据用户名模糊查询用户
    List<User> getByName(String name);
    //添加用户
    int addUser(User user);
    //删除用户
    int delUser(int id);
    //修改用户
    int Update(User user);
}
