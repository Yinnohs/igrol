package com.yinnohs.igrol.user.application;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;


@RequiredArgsConstructor
public class FindSpecificUserUseCase implements BiFunction<String, String , User> {

    private UserService userService;

    @Override
    public User apply(String findType, String value) {
        String sanitizeType = findType.toLowerCase().trim();
        return userService.findBy(sanitizeType, value);
    }
}
