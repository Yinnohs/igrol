package com.yinnohs.igrol.user.infrastructure.dto;

import java.time.LocalDateTime;

public record CreateUserDto(
         String name,
         String surname,
         String email,
         String address,
         String phoneNumber
) {
}
