package com.yinnohs.igrol.user.infrastructure.dto;

public record CreateUserRequest(
         String name,
         String surname,
         String email,
         String address,
         String phoneNumber,
         String password
) {
}
