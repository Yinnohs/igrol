package com.yinnohs.igrol.product.domain.model;

import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private String id;
    private String imageUrl;
    private String name;
    private BigDecimal price;

    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
