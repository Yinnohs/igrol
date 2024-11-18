package com.yinnohs.igrol.user.infrastructure.controller;

import com.yinnohs.igrol.user.application.service.UserUseCases;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.infrastructure.dto.CreateUserRequest;
import com.yinnohs.igrol.user.infrastructure.dto.UpdateUserAddressRequest;
import com.yinnohs.igrol.user.infrastructure.dto.UpdateUserEmailRequest;
import com.yinnohs.igrol.user.infrastructure.dto.UpdateUserPhoneNumberRequest;
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
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request){
        User userToCreate = userMapper.createDtoToUser(request);

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

    @PutMapping("/phone")
    public ResponseEntity<?> updateUserPhoneNumber(@RequestBody UpdateUserPhoneNumberRequest request){
        return ResponseEntity.ok(userUseCases.updateUserPhoneNumber(request.userId(), request.phoneNumber()));
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateUserEmail(@RequestBody UpdateUserEmailRequest request){
        return ResponseEntity.ok(userUseCases.updateUserEmail(request.userId(), request.email()));
    }

    @PutMapping("/address")
    public ResponseEntity<?> updateUserAddress(@RequestBody UpdateUserAddressRequest request){
        return ResponseEntity.ok(userUseCases.updateUserAddress(request.userId(), request.userAddress()));
    }

}
