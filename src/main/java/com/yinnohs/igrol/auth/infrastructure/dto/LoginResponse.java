package com.yinnohs.igrol.auth.infrastructure.dto;

import com.yinnohs.igrol.user.infrastructure.dto.UserResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Valid
public record LoginResponse(
        @NotEmpty
        String token,
        @NotNull
        UserResponseDto user
) {
}
