package com.yinnohs.igrol.product.domain.port;


import com.yinnohs.igrol.product.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(final String productId);
    Product save(final Product product);
    Boolean deleteById(final String productId);
    Product findByPrice(final BigDecimal price);
    Product findByName(String productName);
}
