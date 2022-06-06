package com.weifang.mapper;

import com.weifang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户信息
    List<User> getAll();

}
