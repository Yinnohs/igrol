package com.yinnohs.igrol.product.infrastructure.mapper;

import com.yinnohs.igrol.product.domain.model.Product;
import com.yinnohs.igrol.product.infrastructure.document.ProductDocument;
import com.yinnohs.igrol.product.infrastructure.dto.CreateProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public  Product createRequestToDocument(CreateProductRequest request){
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .imageUrl(request.imageUrl())
                .build();
    }
}
