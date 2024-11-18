package com.yinnohs.igrol.user.infrastructure.controller;

import com.yinnohs.igrol.user.application.service.UserUseCases;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.infrastructure.dto.CreateUserRequest;
import com.yinnohs.igrol.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCases userUseCases;
    private final UserMapper userMapper;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest dto){
        User userToCreate = userMapper.createDtoToUser(dto);

        User user = userUseCases.create(userToCreate);

        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(userUseCases.findAll());
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> findByUserId(@PathVariable("userid") String userid ){
        return ResponseEntity.ok(userUseCases.findById(userid));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userid") String userid){
        userUseCases.deleteUserById(userid);
        return ResponseEntity.ok("User Deleted successfully");
    }

    @PutMapping("")
}
