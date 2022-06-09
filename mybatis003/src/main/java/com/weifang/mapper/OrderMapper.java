package com.weifang.mapper;

import com.weifang.pojo.Orders;

public interface OrderMapper {
    Orders getByOrderId(Integer id);
    Orders getOrderByCustomerId(Integer id);
}
