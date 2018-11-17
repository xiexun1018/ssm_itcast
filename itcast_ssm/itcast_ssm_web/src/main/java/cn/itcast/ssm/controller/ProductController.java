package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/13
 * @time:10:55
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
/*
    @RequestMapping("/toMain")
    public String toMain() {
        return "main";
    }*/

    @RequestMapping("/findAll")

    public ModelAndView findAllTest() {
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "product-add";
    }

    @RequestMapping("/addProduct")
    @RolesAllowed("ADMIN")
    public String addProductTest(Product product) {
        System.out.println(product);
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
