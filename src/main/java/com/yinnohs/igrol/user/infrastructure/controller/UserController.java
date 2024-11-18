package com.yinnohs.igrol.user.infrastructure.controller;

import com.yinnohs.igrol.user.application.service.UserUseCases;
import com.yinnohs.igrol.user.infrastructure.dto.CreateUserDto;
import com.yinnohs.igrol.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCases userUseCases;
    private final UserMapper userMapper;

    @PostMapping()
    public ResponseEntity<?> createUser(CreateUserDto dto){
        var userToCreate = userMapper.createDtoToUser(dto);

        return ResponseEntity.ok(userUseCases.create(userToCreate));
    }
}
