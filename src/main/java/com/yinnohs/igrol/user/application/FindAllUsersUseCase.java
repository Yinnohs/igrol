package com.yinnohs.igrol.user.application;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public class FindAllUsersUseCase implements Function<Void, List<User>> {

    private final UserService userService;

    @Override
    public List<User> apply(Void unused) {
        return userService.findAll();
    }
}
