package com.yinnohs.igrol.user.infrastructure.entity;


import com.yinnohs.igrol.user.domain.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("user")
public class UserEntity {

    @Id
    private String id;
    private String name;
    private String surname;
    @NotNull
    private String email;
    private String address;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime lastLoginAt;
    @LastModifiedDate
    private LocalDateTime lastUpdate;

    public static UserEntity fromUserModel(User user){
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .address(user.getAddress())
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .lastUpdate(user.getLastUpdate())
                .lastLoginAt(user.getLastLoginAt())
                .password(user.getPassword())
                .build();
    }

    public static User toUserModel(UserEntity user){
        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .address(user.getAddress())
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .lastUpdate(user.getLastUpdate())
                .lastLoginAt(user.getLastLoginAt())
                .password(user.getPassword())
                .build();
    }

}
