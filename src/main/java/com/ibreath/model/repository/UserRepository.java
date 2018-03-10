package com.ibreath.model.repository;

import com.ibreath.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository  extends CrudRepository<UserEntity, Long> {
}
