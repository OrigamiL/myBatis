package com.weifang;

import com.weifang.mapper.UserMapper;
import com.weifang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: myBatis
 * @ClassName: MyTest
 * @Version: 1.0
 * @Description: test
 * @Author: zhezhi
 * @Create-Date: 2022-06-08 14:36
 **/

public class MyTest {
    SqlSession sqlSession;
    @Before
    public void openSqlSession() {
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = factory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
    @Test
    public void testGetAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetByCondition() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1946-06-16").getTime());
        List<User> userList = userMapper.getByCondition(new User("aa",date,"2","上海"));
        userList.forEach(System.out::println);
    }
    @Test
    public void testUpdate() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(27);
        user.setUsername("周二");
        user.setAddress("beijing");
        int res = userMapper.Update(user);
        sqlSession.commit();
        testGetAll();
    }
    @Test
    public void testGetByIds() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer[] arr = {1,2,4};
        List<User> userList = userMapper.getByIds(arr);
        userList.forEach(System.out::println);
    }
    @Test
    public void testDelByIds() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer[] arr = {18,19,20,21};
        int res = userMapper.delByIds(arr);
        System.out.println(res);
        sqlSession.commit();
        testGetAll();
    }
    @Test
    public void testAddUsers() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01").getTime());
        User user1 = new User("testAdd1", date, "1", "北京");
        User user2 = new User("testAdd2", date, "2", "青岛");
        User user3 = new User("testAdd3", date, "1", "潍坊");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userMapper.addUsers(userList);
        sqlSession.commit();
        userMapper.getAll();
    }
}
