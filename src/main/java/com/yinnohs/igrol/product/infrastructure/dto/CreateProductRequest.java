package com.yinnohs.igrol.product.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record CreateProductRequest(
        @NotNull
        String name,
        @NotNull
        String imageUrl,
        @NotNull
        BigDecimal price
) {
}
