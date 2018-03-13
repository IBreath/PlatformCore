package com.ibreath.resource.model.repository;

import com.ibreath.resource.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
