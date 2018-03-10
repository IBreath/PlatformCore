package com.ibreath.model.repository;

import com.ibreath.model.entity.LearningIndicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningIndicationRepository extends CrudRepository<LearningIndicationEntity, Long> {
}
