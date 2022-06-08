package com.weifang.mapper;

import com.weifang.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getAll();
    //按指定的条件进行多条件查询
    List<User> getByCondition(User user);
    //更新 至少一列
    Integer Update(User user);
    //查询多个指定id的用户信息
    List<User> getByIds(Integer[] arr);
    //删除多个指定id的用户信息
    int delByIds(Integer[] arr);
    //批量增加用户
    int addUsers(List<User> userList);
}
