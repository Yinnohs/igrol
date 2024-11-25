package com.yinnohs.igrol.product.application;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.Function;

@RequiredArgsConstructor
public class CreateNewProductUseCase implements Function<Product, Product> {
    private final ProductService productService;

    @Override
    public Product apply(Product product) {
        LocalDateTime now = LocalDateTime.now();
        product.setCreatedAt(now);
        product.setLastUpdate(now);
        return productService.create(product);
    }
}
