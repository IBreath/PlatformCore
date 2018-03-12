package com.ibreath.model.repository;

import com.ibreath.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Long> {
}
