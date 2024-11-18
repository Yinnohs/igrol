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

    public User updateUserEmail(String userid, String newEmail){
        User userToUpdate = userRepository.findById(userid);
        userToUpdate.setEmail(newEmail);
        return userRepository.save(userToUpdate);
    }

    public User updateUserAddress(String userid, String address){
        User userToUpdate = userRepository.findById(userid);
        userToUpdate.setAddress(address);
        return userRepository.save(userToUpdate);
    }

    public User updateUserPhoneNumber(String userid, String phoneNumber){
        User userToUpdate = userRepository.findById(userid);
        userToUpdate.setPhoneNumber(phoneNumber);
        return userRepository.save(userToUpdate);
    }
}
