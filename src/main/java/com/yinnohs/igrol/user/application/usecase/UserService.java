package com.yinnohs.igrol.user.application.usecase;

import com.yinnohs.igrol.shared.exception.NotSupportedFindType;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final String TYPE_FIND_BY_ID = "id";
    private final String TYPE_FIND_BY_EMAIL = "email";
    private final String TYPE_FIND_BY_PHONE_NUMBER = "phone";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        var now = LocalDateTime.now();

        user.setCreatedAt(now);

        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findBy(String findType , String value){
        String sanitizeType = findType.toLowerCase().trim();
        if (sanitizeType.equals(TYPE_FIND_BY_ID)) return userRepository.findById(value);
        if (sanitizeType.equals(TYPE_FIND_BY_EMAIL)) return userRepository.findByEmail(value);
        if (sanitizeType.equals(TYPE_FIND_BY_PHONE_NUMBER)) return userRepository.findByPhoneNumber(value);
        throw new NotSupportedFindType("Find type not supported please try to find by id, email or phone");

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
