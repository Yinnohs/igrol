package com.yinnohs.igrol.product.application;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class ChangeProductPriceUseCase implements BiFunction<String, BigDecimal, Product> {
    private final ProductService productService;

    @Override
    public Product apply(String productId, BigDecimal price) {
        Product productToUpdate = productService.findBy("id", productId);
        productToUpdate.setPrice(price);
        productToUpdate.setLastUpdate(LocalDateTime.now());
        return productService.saveProduct(productToUpdate);
    }
}