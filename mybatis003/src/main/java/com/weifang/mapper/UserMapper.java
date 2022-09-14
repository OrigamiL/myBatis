package com.weifang.mapper;

import com.weifang.pojo.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    //批量更新用户
    int updateUsers(List<User> userList);
    //查询指定日期范围内的用户
    List<User> getByBirthday(Date begin,Date end);
    //入参是map
    List<User> getByMap(Map<?,?> map);
    Map<String,Object> getReturnMap(Integer id);
    List<Map<String,Object>> getReturnMaps();
    List<Map<String,Object>> getReturnMaps(Integer[] arr);
    List<Map<String,Object>> getByMapAndReturnMap(Map<?,?> map);
    User getById(Integer id);
}
