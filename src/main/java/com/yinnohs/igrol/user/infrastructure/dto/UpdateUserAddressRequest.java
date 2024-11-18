package com.yinnohs.igrol.user.infrastructure.dto;

public record UpdateUserAddressRequest(
        String userId,
        String userAddress
) {
}
