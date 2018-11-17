package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void saveProduct(Product product);
    Product findById(String id);
}
