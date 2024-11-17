package com.yinnohs.igrol.user.domain.service;

import com.yinnohs.igrol.user.domain.errors.UserNotFoundError;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.outsource.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundError("Could not be found user with id: " + id));
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }
}
