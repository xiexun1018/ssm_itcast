package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> findAll();
    Orders findById(String ordersId);
}
