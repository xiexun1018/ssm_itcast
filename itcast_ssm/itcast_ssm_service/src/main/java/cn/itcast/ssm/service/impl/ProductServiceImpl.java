package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:xiexun
 * @date:2018/11/13
 * @time:10:38
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    public Product findById(String id) {
        return productDao.findById(id);
    }
}
