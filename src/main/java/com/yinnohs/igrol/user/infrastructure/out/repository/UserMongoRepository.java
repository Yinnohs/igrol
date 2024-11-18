package com.yinnohs.igrol.user.infrastructure.out.repository;

import com.yinnohs.igrol.user.domain.errors.UserNotFoundError;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.outsource.UserRepository;
import com.yinnohs.igrol.user.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMongoRepository implements UserRepository {

    private final UserMongoDbRepository mongoRepository;

    MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll() {
        List<UserEntity> users = mongoRepository.findAll();
        return users.stream().map(UserEntity::toUserModel).toList();
    }

    @Override
    public User findById(String userId) {
        UserEntity user = mongoRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundError("Could not be faound suer with id: " + userId));

        return  UserEntity.toUserModel(user);
    }

    @Override
    public User save(User user) {
        var savedUser = mongoRepository.save(UserEntity.fromUserModel(user));
        return UserEntity.toUserModel(savedUser);
    }

    @Override
    public Boolean deleteById(String userId) {
        return null;
    }
}
