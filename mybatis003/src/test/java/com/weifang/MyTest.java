package com.weifang;

import com.weifang.mapper.BookMapper;
import com.weifang.mapper.CustomerMapper;
import com.weifang.mapper.OrderMapper;
import com.weifang.mapper.UserMapper;
import com.weifang.pojo.Book;
import com.weifang.pojo.Customer;
import com.weifang.pojo.Orders;
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
import java.util.*;

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
    UserMapper userMapper;
    BookMapper bookMapper;
    CustomerMapper customerMapper;
    OrderMapper orderMapper;
    @Before
    public void getMapper() {
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = factory.openSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
            bookMapper = sqlSession.getMapper(BookMapper.class);
            customerMapper = sqlSession.getMapper(CustomerMapper.class);
            orderMapper = sqlSession.getMapper(OrderMapper.class);
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
        List<User> userList = userMapper.getAll();
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetByCondition() throws ParseException {
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1946-06-16").getTime());
        List<User> userList = userMapper.getByCondition(new User("aa",date,"2","上海"));
        userList.forEach(System.out::println);
    }
    @Test
    public void testUpdate() {
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
        Integer[] arr = {1,2,4};
        List<User> userList = userMapper.getByIds(arr);
        userList.forEach(System.out::println);
    }
    @Test
    public void testDelByIds() {
        Integer[] arr = {18,19,20,21};
        int res = userMapper.delByIds(arr);
        System.out.println(res);
        sqlSession.commit();
        testGetAll();
    }
    @Test
    public void testAddUsers() throws ParseException {
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01").getTime());
        User user1 = new User("testAdd1", date, "1", "北京");
        User user2 = new User("testAdd2", date, "2", "青岛");
        User user3 = new User("testAdd3", date, "1", "潍坊");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        int res = userMapper.addUsers(userList);
        sqlSession.commit();
        userMapper.getAll();
    }
    @Test
    public void testUpdateUsers() throws ParseException {
        Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01").getTime());
        User user1 = new User(1,"testAdd1", date, "2", "北京");
        User user2 = new User(2,"testAdd2", date, "1", "青岛");
        User user3 = new User(3,"testAdd3", date, "2", "潍坊");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        int res = userMapper.updateUsers(userList);
        sqlSession.commit();
        userMapper.getAll();
    }
    @Test
    public void testGetByBirthday() throws ParseException {
        Date begin = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-02").getTime());
        Date end = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2006-01-01").getTime());
        List<User> userList = userMapper.getByBirthday(begin,end);
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetByMap() throws ParseException {
        Date begin = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-02").getTime());
        Date end = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1999-01-01").getTime());
        Map<String,Object> map = new HashMap<>();
        map.put("birthdayBegin",begin);
        map.put("birthdayEnd",end);
        map.put("sex",2);
        List<User> userList = userMapper.getByMap(map);
        userList.forEach(System.out::println);
    }
    @Test
    public void testGetReturnMap() {
        Map<String,Object> userMap = userMapper.getReturnMap(1);
        Set<Map.Entry<String, Object>> entrySet = userMap.entrySet();
        for (Map.Entry<String, Object> e :
                entrySet) {
            System.out.println(e.getKey()+"="+e.getValue());
        }
    }
    @Test
    public void testGetReturnMaps() {
        List<Map<String,Object>> mapList = userMapper.getReturnMaps(new Integer[]{1,2,3});
        mapList.forEach(System.out::println);
    }
    @Test
    public void testGetAllBook() {
        List<Book> bookList = bookMapper.getAll();
        bookList.forEach(System.out::println);
    }
    @Test
    public void testGetAll2Book() {
        List<Book> bookList = bookMapper.getAll2();
        bookList.forEach(System.out::println);
    }
    @Test
    public void testGetById() {
        Customer customer = customerMapper.getById(3);
        System.out.println(customer);
    }
    @Test
    public void testGetByOrderId() {
        Orders orders = orderMapper.getByOrderId(11);
        System.out.println(orders);
    }
    @Test
    public void testGetOrderById() {
        Customer customer = customerMapper.getOrderById(1);
        System.out.println(customer);
    }
    @Test
    public void testCache2() {
        User user = userMapper.getById(5);
        User user1 = userMapper.getById(5);
        System.out.println(user);
        System.out.println(user1);
    }
    @Test
    public void testCache3() {
        User user = userMapper.getById(5);
        User user1 = userMapper.getById(5);
        System.out.println(user);
        System.out.println(user1);
    }
}
