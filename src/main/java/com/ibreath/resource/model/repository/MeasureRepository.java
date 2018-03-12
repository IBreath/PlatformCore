package com.ibreath.resource.model.repository;

import com.ibreath.resource.model.entity.MeasureEntity;
import com.ibreath.resource.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasureRepository extends CrudRepository<MeasureEntity, Long> {
    List<MeasureEntity> findFirst10AlcoholMeasureByUserEntity(@Param("userEntity") UserEntity userEntity);
    MeasureEntity findTopByUserEntityOrderByDateTime(@Param("userEntity") UserEntity userEntity);
}
