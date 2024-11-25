package com.yinnohs.igrol.auth.infrastructure.configuration;

import com.yinnohs.igrol.auth.application.FindUserByEmailUseCase;
import com.yinnohs.igrol.auth.application.SignUpUserUseCase;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthBeanConfiguration {

    @Bean
    public FindUserByEmailUseCase getUserByEmailUseCase(UserService userService){
        return new FindUserByEmailUseCase(userService);
    }

    @Bean
    public SignUpUserUseCase singUpUserUseCase(UserService userService){
        return new SignUpUserUseCase(userService);
    }
}
