package com.yinnohs.igrol.product.infrastructure.mapper;

import com.yinnohs.igrol.product.infrastructure.document.ProductDocument;
import com.yinnohs.igrol.product.infrastructure.dto.CreateProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    ProductDocument createRequestToDocument(CreateProductRequest request){
        return ProductDocument.builder()
                .name(request.name())
                .price(request.price())
                .imageUrl(request.imageUrl())
                .build();
    }
}
