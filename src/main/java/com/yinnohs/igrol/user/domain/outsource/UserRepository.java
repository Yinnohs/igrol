package com.yinnohs.igrol.user.domain.outsource;

import com.yinnohs.igrol.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(final String userId);
    User save(final User user);
    Boolean deleteById(String userId);
}
