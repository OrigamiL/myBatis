package com.weifang;

import com.weifang.pojo.Student;
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
 * @Description: test
 * @Author: zhezhi
 * @Create-Date: 2022-06-05 14:32
 **/

public class MyTest {
    protected SqlSession sqlSession;

    @Before
    public void openSqlSession() {
        String resource = "SqlMapConfig.xml";
        try {
            //使用文件流读取核心配置文件SqlMapConfig.xml
            InputStream in = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
            //取出SqlSession对象
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
        //完成查询操作
        List<Student> studentList = sqlSession.selectList("getAll");
        studentList.forEach(System.out::println);
    }

    @Test
    public void testGetAgeGt() throws IOException {
        List<Student> studentList = sqlSession.selectList("zhezhi.getAgeGt", "22");
        sqlSession.close();
        studentList.forEach(System.out::println);
    }

    @Test
    public void testGetById() throws IOException {
        Student student = sqlSession.selectOne("zhezhi.getById", "1");
        System.out.println(student);
    }

    @Test
    public void testGetId2() throws IOException {
        List<Student> studentList = sqlSession.selectList("zhezhi.getById", "3");
        studentList.forEach(System.out::println);
    }

    @Test
    public void testGetByName() throws IOException {
        List<Student> studentList = sqlSession.selectList("zhezhi.getByName", "张");
        studentList.forEach(System.out::println);
    }

    @Test
    public void testAddStudent() {
        int insert = sqlSession.insert("addStudent",
                new Student("jack", "123@qq.com", 33));
        System.out.println(insert);
        sqlSession.commit();
        testGetAll();
    }

    @Test
    public void testDelStudent() {
        sqlSession.delete("delStudent", "9");
        sqlSession.commit();
        testGetAll();
    }

    @Test
    public void testUpdate() {

        int update = sqlSession.update("zhezhi.update",
                new Student(5, "zhangSan", "123@qq.com", 44));
        sqlSession.commit();
        System.out.println(update);
        testGetAll();
    }

}
