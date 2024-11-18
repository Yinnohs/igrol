package com.yinnohs.igrol.user.infrastructure.mapper;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.infrastructure.dto.CreateUserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public  User createDtoToUser(CreateUserDto createUserDto){
        return User.builder()
                .name(createUserDto.name())
                .surname(createUserDto.surname())
                .address(createUserDto.address())
                .email(createUserDto.email())
                .phoneNumber(createUserDto.phoneNumber())
                .build();
    }
}
