package com.yinnohs.igrol.auth.application;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.Function;

@RequiredArgsConstructor
public class SingUpUserUseCase implements Function<User, User> {

    private final UserService userService;


    @Override
    public User apply(User user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        return  userService.create(user);
    }
}
