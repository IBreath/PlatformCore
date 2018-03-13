package com.ibreath.service;

import com.ibreath.enumeration.GenderEnum;
import com.ibreath.resource.dto.UserDto;
import com.ibreath.resource.mapper.UserMapper;
import com.ibreath.resource.model.entity.UserEntity;
import com.ibreath.resource.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository repository;
    private UserMapper userMapper;

    private static Logger logger = Logger.getLogger(UserService.class);

    public UserDto getUser(String userId) throws Exception {

        UserEntity entity = repository.findOne(Long.valueOf(userId));
        if (entity == null) {
            throw new Exception("The user doesen't exist");
        }
        UserDto dto = userMapper.mapEntityToDto(entity);
        return dto;
    }

    public UserDto createUser(UserDto dto) throws Exception {

        if (emailExist(dto.getEmail())) {
            logger.fatal("There is an account with that email adress: " +  dto.getEmail());
            throw new Exception(
                    "There is an account with that email adress: " +  dto.getEmail());
        }

        UserEntity entity = userMapper.mapDtoToEntity(dto);
        repository.save(entity);
        dto.setDecreaseRate(entity.getDecreaseRate());
        return dto;
    }

    private boolean emailExist(String email) {
        UserEntity user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Autowired
    public UserService setRepository(UserRepository repository) {
        this.repository = repository;
        return this;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
