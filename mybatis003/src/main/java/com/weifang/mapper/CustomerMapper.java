package com.weifang.mapper;

import com.weifang.pojo.Customer;

public interface CustomerMapper {
    Customer getById(Integer id);
    Customer getOrderById(Integer id);
}
