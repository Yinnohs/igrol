package com.yinnohs.igrol.user.infrastructure.out.repository;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.outsource.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserMongoRepository implements UserRepository {

    MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Boolean deleteById(String userId) {
        return null;
    }
}
