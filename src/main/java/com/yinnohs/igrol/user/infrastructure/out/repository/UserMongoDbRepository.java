package com.yinnohs.igrol.user.infrastructure.out.repository;

import com.yinnohs.igrol.user.infrastructure.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoDbRepository extends MongoRepository<UserEntity, String> {
}
