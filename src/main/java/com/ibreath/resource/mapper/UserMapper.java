package com.ibreath.resource.mapper;

import com.ibreath.enumeration.GenderEnum;
import com.ibreath.resource.dto.UserDto;
import com.ibreath.resource.model.entity.UserEntity;
import com.ibreath.utils.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {

    @Override
    public UserEntity mapDtoToEntity(UserDto dto) {
        UserEntity userEntity = new UserEntity();
        if (dto.getId() != null)
            userEntity.setId(dto.getId());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setFirstname(dto.getFirstname());
        userEntity.setLastname(dto.getLastname());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setGender(dto.getGender());
        userEntity.setWeight(dto.getWeight());
        userEntity.setHeight(dto.getHeight());
        userEntity.setBirthDate(dto.getBirthDate());
        if (dto.getGender().equals(GenderEnum.MALE)) {
            userEntity.setDecreaseRate(0.00125);
        } else {
            userEntity.setDecreaseRate(0.00085);
        }
        return userEntity;
    }

    @Override
    public UserDto mapEntityToDto(UserEntity entity) {
        UserDto userDto = new UserDto();
        if (entity.getId() != null)
            userDto.setId(entity.getId());
        userDto.setFirstname(entity.getFirstname());
        userDto.setLastname(entity.getLastname());
        userDto.setEmail(entity.getEmail());
        userDto.setGender(entity.getGender());
        userDto.setWeight(entity.getWeight());
        userDto.setHeight(entity.getHeight());
        userDto.setBirthDate(entity.getBirthDate());
        userDto.setDecreaseRate(entity.getDecreaseRate());
        return userDto;
    }

    @Override
    public UserDto mapEntityIdToDto(UserEntity entity) {
        return null;
    }
}
