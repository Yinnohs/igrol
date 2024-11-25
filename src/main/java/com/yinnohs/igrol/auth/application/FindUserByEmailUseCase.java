package com.yinnohs.igrol.auth.application;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class FindUserByEmailUseCase implements Function<String , User> {

    private final UserService userService;


    @Override
    public User apply(String email) {
        return userService.findBy("email", email);
    }
}
