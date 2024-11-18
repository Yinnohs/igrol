package com.yinnohs.igrol.user.application.service;

import com.yinnohs.igrol.user.domain.errors.UserNotFoundError;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.outsource.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCases {
    private final UserRepository userRepository;

    public UserUseCases(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
