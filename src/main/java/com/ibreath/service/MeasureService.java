package com.ibreath.service;

import com.ibreath.model.entity.AlcoholMesure;
import com.ibreath.model.entity.LearningIndicationEntity;
import com.ibreath.model.entity.UserEntity;
import com.ibreath.model.repository.AlcoholRepository;
import com.ibreath.model.repository.LearningIndicationRepository;
import com.ibreath.model.repository.UserRepository;
import com.ibreath.resource.MeasureResource;
import com.ibreath.resource.PostMeasureResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasureService {

    private AlcoholRepository repository;
    private UserRepository userRepository;
    private LearningIndicationRepository learningIndicationRepository;

    public List<MeasureResource> getLast10Values(String userId) {

        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        List<AlcoholMesure> alcoholMesures = repository.findFirst10AlcoholMesureByUserEntity(userEntity);

        List<MeasureResource> resources = new ArrayList<>();

        alcoholMesures.forEach( e ->  {
            MeasureResource mapper = new MeasureResource();
            mapper.setId(e.getId());
            mapper.setDateTime(e.getDateTime());
            mapper.setLearningIndicationEntity(e.getLearningIndicationEntity());
            mapper.setUserEntity(e.getUserEntity());
            mapper.setValue(e.getValue());
            resources.add(mapper);
        }  );

       return resources;
    }

    public PostMeasureResource post(String userId, PostMeasureResource resource) {
        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        LearningIndicationEntity learningIndicationEntity = learningIndicationRepository.findOne(resource.getLearningIndication());

        AlcoholMesure mesure = new AlcoholMesure();
        mesure.setUserEntity(userEntity);
        mesure.setLearningIndicationEntity(learningIndicationEntity);
        mesure.setDateTime(LocalDateTime.now());
        mesure.setValue(resource.getValue());

        repository.save(mesure);

        return resource;
    }

    @Autowired
    public void setRepository(AlcoholRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLearningIndicationRepository(LearningIndicationRepository learningIndicationRepository) {
        this.learningIndicationRepository = learningIndicationRepository;
    }
}
