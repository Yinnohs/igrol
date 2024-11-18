package com.yinnohs.igrol.user.infrastructure.dto;

public record UpdateUserPhoneNumberRequest(
        String userId,
        String phoneNumber
) {
}
