package com.yinnohs.igrol.user.infrastructure.document;


import com.yinnohs.igrol.user.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("user")
public class UserDocument {

    @Id
    private String id;
    private String name;
    private String surname;
    @NotNull
    @Email
    @Indexed(unique = true)
    private String email;
    private String address;
    @NotNull
    @Indexed(unique = true)
    private String phoneNumber;
    @NotNull
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime lastLoginAt;
    @LastModifiedDate
    private LocalDateTime lastUpdate;

    public static UserDocument fromUserModel(User user){
        return UserDocument.builder()
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

    public static User toUserModel(UserDocument user){
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
