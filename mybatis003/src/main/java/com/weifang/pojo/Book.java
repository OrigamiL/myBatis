package com.weifang.pojo;

/**
 * @Program: myBatis
 * @ClassName: Book
 * @Version: 1.0
 * @Description: book类
 * @Author: zhezhi
 * @Create-Date: 2022-06-09 14:10
 **/

public class Book {
    private Integer id;
    private String name;

    public Book() {
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
