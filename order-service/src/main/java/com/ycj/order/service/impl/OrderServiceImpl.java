package com.ycj.order.service.impl;

import com.ycj.order.mapper.OrderMapper;
import com.ycj.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int getOrderTotal(){
        return orderMapper.getOrderTotal();
    }
}
