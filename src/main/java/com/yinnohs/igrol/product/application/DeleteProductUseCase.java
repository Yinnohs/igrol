package com.yinnohs.igrol.product.application;

import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteProductUseCase implements Function<String, Void> {
    private final ProductService productService;

    @Override
    public Void apply(String productId) {
        productService.deleteById(productId);
        return null;
    }
}
