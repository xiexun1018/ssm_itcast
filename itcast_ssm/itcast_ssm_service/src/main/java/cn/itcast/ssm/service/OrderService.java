package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();
    List<Orders> findByPage(Integer currentPage,Integer pageSize);
    Orders findById(String ordersId);
}
