package com.yinnohs.igrol.product.infrastructure.dto;

import jakarta.validation.constraints.NotNull;


public record UpdateProductNameRequest(
        @NotNull
        String productId,
        @NotNull
        String name
) {
}
