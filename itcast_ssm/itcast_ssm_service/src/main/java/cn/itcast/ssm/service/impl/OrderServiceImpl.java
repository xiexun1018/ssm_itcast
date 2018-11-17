package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.OrderDao;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/13
 * @time:16:48
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public List<Orders> findAll() {
//        从第几页开始查询，每页显示多少条数据

        return orderDao.findAll();
    }

    public List<Orders> findByPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return orderDao.findAll();
    }

    public Orders findById(String ordersId) {
        return orderDao.findById(ordersId);
    }
}
