package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Traveller;

import java.util.List;

public interface TravellerDao {
    List<Traveller> findByOrdersId(String ordersId);
}
