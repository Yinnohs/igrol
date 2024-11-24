package com.yinnohs.igrol.auth.infrastructure.dto;

public record CreateUserRequest(
         String name,
         String surname,
         String email,
         String address,
         String phoneNumber,
         String password
) {
}
