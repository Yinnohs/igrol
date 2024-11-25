package com.yinnohs.igrol.product.domain.service;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.shared.exception.NotSupportedFindType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findBy(String type, String value);
    public Product create(Product product);
    public void deleteById(String productId);
    public Product saveProduct(Product product);
}
