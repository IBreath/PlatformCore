package com.ibreath.model.repository;

import com.ibreath.model.entity.AlcoholMesure;
import com.ibreath.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends CrudRepository<AlcoholMesure, Long>{
    List<AlcoholMesure> findFirst10AlcoholMesureByUserEntity(@Param("userEntity") UserEntity userEntity);
}
