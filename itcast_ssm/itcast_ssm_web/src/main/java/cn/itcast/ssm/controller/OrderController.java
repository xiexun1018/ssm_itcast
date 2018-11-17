package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/13
 * @time:16:46
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAllTest(){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders = orderService.findAll();
        modelAndView.setViewName("orders-list");
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }

    @RequestMapping("/findByPage")
    public ModelAndView findByPageTest(@RequestParam(name = "page",required = true,defaultValue = "1") Integer currentPage, @RequestParam(name = "size",required = true,defaultValue  = "5") Integer pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = orderService.findByPage(currentPage, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.setViewName("orders-list");
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findByIdTest(String id){
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = orderService.findById(id);
        modelAndView.setViewName("orders-show");
        modelAndView.addObject("orders",orders);
        return modelAndView;
    }
}
