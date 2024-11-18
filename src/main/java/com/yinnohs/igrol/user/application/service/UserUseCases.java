package com.yinnohs.igrol.user.application.service;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.outsource.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserUseCases {
    private final UserRepository userRepository;

    public UserUseCases(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        var now = LocalDateTime.now();

        user.setCreatedAt(now);

        return userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUserById(String userid){
        userRepository.deleteById(userid);
    }
}
