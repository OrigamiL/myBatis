package com.weifang.pojo;

import java.util.List;

/**
 * @Program: myBatis
 * @ClassName: Customer
 * @Version: 1.0
 * @Description: 顾客
 * @Author: zhezhi
 * @Create-Date: 2022-06-09 16:17
 **/

public class Customer {
    private Integer id;
    private String name;
    private Integer age;
    private List<Orders> ordersList;

    public Customer() {
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name, Integer age, List<Orders> ordersList) {
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
    }

    public Customer(Integer id, String name, Integer age, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Orders> getOrderList() {
        return ordersList;
    }

    public void setOrderList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orderList=" + ordersList +
                '}';
    }
}
