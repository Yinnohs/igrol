package com.yinnohs.igrol.user.domain.port.in;

import com.yinnohs.igrol.shared.exception.NotSupportedFindType;
import com.yinnohs.igrol.user.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    public User create(User user);
    public List<User> findAll();
    public User findBy(String findType , String value);
    public void deleteUserById(String userid);
    public User updateUserEmail(String userid, String newEmail);
    public User updateUserAddress(String userid, String address);
    public User updateUserPhoneNumber(String userid, String phoneNumber);
}
