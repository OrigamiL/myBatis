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
import java.util.List;
import java.util.UUID;

/**
 * @Program: myBatis
 * @ClassName: MyTest
 * @Version: 1.0
 * @Description: test-dynamic-proxy
 * @Author: zhezhi
 * @Create-Date: 2022-06-06 18:16
 **/

public class MyTest {
    SqlSession sqlSession;
    @Before
    public void openSqlSession() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
    }
    @After
    public void closeSqlSession() {
        sqlSession.close();
    }
    @Test
    public void testGetAll() {
        List<User> userList = sqlSession.selectList("com.weifang.mapper.UserMapper.getAll");
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetAl2l() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetById() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getById(4);
        System.out.println(user);
    }
    @Test
    public void testAddUser() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-11").getTime());
        User user = new User("test", date, 2, "上海市");
        int add = userMapper.addUser(user);
        System.out.println(add);
        sqlSession.commit();
        System.out.println(user);
     //   testGetAl2l();
    }
    @Test
    public void testDelUser() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int del = userMapper.delUser(28);
        System.out.println(del);
        sqlSession.commit();
        testGetAl2l();
    }
    @Test
    public void TestUpdate() throws ParseException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1994-11-10").getTime());
        int update = userMapper.Update(new User(1, "张四", date, 1, "枣庄"));
        System.out.println(update);
        sqlSession.commit();
        testGetAl2l();
    }
    @Test
    public void testGetByName() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getByName("小");
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetByName2() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getByName2("张");
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetByNameOrAddress() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getByNameOrAddress("address","市");
        userList.forEach(System.out::println);
    }
    @Test
    public void testUUID() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").substring(0,5));
    }
}
