package com.yinnohs.igrol.product.application;


import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class FindSpecificProductUseCase implements BiFunction<String,String, Product> {

    private final ProductService productService;

    @Override
    public Product apply(String type, String value) {
        String sanitizeType = type.toLowerCase().trim();
        return productService.findBy(sanitizeType, value);
    }
}
