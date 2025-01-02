package com.yinnohs.igrol.itemlist.infrastrucutre.adapters;

import com.yinnohs.igrol.itemlist.domain.ports.out.ProductAdapter;
import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapterMonolithImpl implements ProductAdapter {

    private final ProductService productService;

    @Override
    public Product findProductById(String productId) {
        return  productService.findBy("id", productId);
    }
}
