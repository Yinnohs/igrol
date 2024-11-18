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

    private final UserMongoDbRepository userMongoRepository;

    MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll() {
        List<UserEntity> users = userMongoRepository.findAll();
        return users.stream().map(UserEntity::toUserModel).toList();
    }

    @Override
    public User findById(String userId) {
        UserEntity user = userMongoRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundError("Could not be found user with id: " + userId));

        return  UserEntity.toUserModel(user);
    }

    @Override
    public User save(User user) {
        var savedUser = userMongoRepository.save(UserEntity.fromUserModel(user));
        return UserEntity.toUserModel(savedUser);
    }

    @Override
    public Boolean deleteById(String userId) {
        userMongoRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundError("Could not be found user with id: " + userId));
        userMongoRepository.deleteById(userId);
        return true;
    }
}
