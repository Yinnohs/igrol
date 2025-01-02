package com.yinnohs.igrol.itemlist.domain.ports.out;

import com.yinnohs.igrol.product.domain.model.Product;

public interface ProductAdapter {
    Product findProductById(String productId);
}
