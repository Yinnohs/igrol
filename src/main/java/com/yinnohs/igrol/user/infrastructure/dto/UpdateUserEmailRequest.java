package com.yinnohs.igrol.user.infrastructure.dto;

public record UpdateUserEmailRequest(
        String userId,
        String email
) {
}
