package com.weifang.pojo;

/**
 * @Program: myBatis
 * @ClassName: Order
 * @Version: 1.0
 * @Description: 订单类
 * @Author: zhezhi
 * @Create-Date: 2022-06-09 16:18
 **/

public class Orders {
    private Integer id;
    private String orderNumber;
    private Double orderPrice;
    //private Integer customer_id;
    private Customer customer;

    public Orders() {
    }


    public Orders(Integer id, String orderNumber, Double orderPrice , Customer customer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPrice=" + orderPrice +
                ", customer=" + customer +
                '}';
    }
}
