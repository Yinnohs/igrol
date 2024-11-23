package com.yinnohs.igrol.user.infrastructure.controller;

import com.yinnohs.igrol.user.infrastructure.service.UserServiceImpl;
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

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping()
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(userService
                .findAll()
                .stream()
                .map(userMapper::userToResponseDto)
                .toList());
    }

    @GetMapping("/find")
    public ResponseEntity<?> findBy(
            @RequestParam(name = "type") String findType,
            @RequestParam(name = "value") String value
    ){
        var user = userService.findBy(findType, value);
        return ResponseEntity.ok(userMapper.userToResponseDto(user));
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userid") String userid){
        userService.deleteUserById(userid);
        return ResponseEntity.ok("User Deleted successfully");
    }

    @PutMapping("/phone")
    public ResponseEntity<?> updateUserPhoneNumber(@RequestBody UpdateUserPhoneNumberRequest request){
        var user = userService.updateUserPhoneNumber(request.userId(), request.phoneNumber());
        return ResponseEntity.ok(userMapper.userToResponseDto(user));
    }

    @PutMapping("/email")
    public ResponseEntity<?> updateUserEmail(@RequestBody UpdateUserEmailRequest request){
        var user = userService.updateUserEmail(request.userId(), request.email());
        return ResponseEntity.ok(userMapper.userToResponseDto(user));
    }

    @PutMapping("/address")
    public ResponseEntity<?> updateUserAddress(@RequestBody UpdateUserAddressRequest request) {
        var user = userService.updateUserAddress(request.userId(), request.userAddress());
        return ResponseEntity.ok(userMapper.userToResponseDto(user));
    }
}
