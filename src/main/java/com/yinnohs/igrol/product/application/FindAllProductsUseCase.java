package com.yinnohs.igrol.product.application;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;


@RequiredArgsConstructor
public class FindAllProductsUseCase implements Function<Void , List<Product> > {

    private final ProductService productService;

    @Override
    public List<Product> apply(Void unused) {
        return productService.findAll();
    }
}
