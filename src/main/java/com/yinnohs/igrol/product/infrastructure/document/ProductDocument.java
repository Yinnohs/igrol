package com.yinnohs.igrol.product.infrastructure.document;


import com.yinnohs.igrol.product.domain.model.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document("product")
@Validated
public class ProductDocument {
    @Id
    private String id;
    private String imageUrl;
    @NotNull
    @NotEmpty
    @Indexed(unique = true)
    private String name;
    @NotNull
    private BigDecimal price;


    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;

    public static ProductDocument fromProductModel(Product product){
        return ProductDocument.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .lastUpdate(product.getLastUpdate())
                .createdAt(product.getCreatedAt())
                .build();
    }

    public static Product toProductModel(ProductDocument product){
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .lastUpdate(product.getLastUpdate())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
