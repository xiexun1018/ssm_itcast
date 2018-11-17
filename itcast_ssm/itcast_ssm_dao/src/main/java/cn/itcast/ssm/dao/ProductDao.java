package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void saveProduct(Product product);
    Product findById(String id);
}
