package com.yinnohs.igrol.product.application;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class ChangeProductImageUseCase implements BiFunction<String,String, Product> {

    private final ProductService productService;

    @Override
    public Product apply(String productId, String imageUrl) {
        Product productToUpdate = productService.findBy("id", productId);
        productToUpdate.setImageUrl(imageUrl);
        productToUpdate.setLastUpdate(LocalDateTime.now());
        return productService.saveProduct(productToUpdate);
    }
}
