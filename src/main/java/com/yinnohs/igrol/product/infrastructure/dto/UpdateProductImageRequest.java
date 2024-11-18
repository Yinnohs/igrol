package com.yinnohs.igrol.product.infrastructure.dto;

import jakarta.validation.constraints.NotNull;


public record UpdateProductImageRequest(
        @NotNull
        String productId,
        @NotNull
        String imageUrl

) {
}
