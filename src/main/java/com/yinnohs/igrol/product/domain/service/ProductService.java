package com.yinnohs.igrol.product.domain.service;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.shared.exception.NotSupportedFindType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ProductService {
    public Product findBy(String type, String value);
    public Product create(Product product);
    public void deleteById(String productId);
    public Product updateProductPrice(String productId, BigDecimal newPrice);
    public Product updateProductName(String productId, String name);
    public Product updateProductImage(String productId, String imageUrl);

}
