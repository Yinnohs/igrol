package com.yinnohs.igrol.user.infrastructure.dto;

public record UserResponseDto(
        String id,
        String name,
        String surname,
        String email,
        String address,
        String phoneNumber
) {
}
