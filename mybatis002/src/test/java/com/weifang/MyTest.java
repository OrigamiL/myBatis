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
import java.util.List;

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
        List<User> userList = sqlSession.selectList("getAll");
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetAl2l() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAll();
        userList.forEach(System.out::println);
    }
}
