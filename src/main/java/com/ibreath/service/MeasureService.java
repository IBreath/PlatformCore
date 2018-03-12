package com.ibreath.service;

import com.ibreath.model.entity.MesureEntity;
import com.ibreath.model.entity.UserEntity;
import com.ibreath.model.repository.AlcoholRepository;
import com.ibreath.model.repository.UserRepository;
import com.ibreath.resource.GetMeasureResource;
import com.ibreath.resource.PostMeasureResource;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasureService {

    private AlcoholRepository repository;
    private UserRepository userRepository;

    public List<GetMeasureResource> getLast10Values(String userId) {

        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        List<MesureEntity> alcoholMesures = repository.findFirst10AlcoholMesureByUserEntity(userEntity);
        List<GetMeasureResource> resources = new ArrayList<>();

        alcoholMesures.forEach( e ->  {
            GetMeasureResource mapper = new GetMeasureResource();
            mapper.setId(e.getId());
            mapper.setDateTime(e.getDateTime());
            mapper.setUserEntity(e.getUserEntity());
            mapper.setValue(e.getValue());
            resources.add(mapper);
        }  );

       return resources;
    }

    public PostMeasureResource postMeasure(String userId, PostMeasureResource resource) {
        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));

        MesureEntity mesure = new MesureEntity();
        mesure.setUserEntity(userEntity);
        mesure.setDateTime(LocalDateTime.now());
        mesure.setValue(resource.getValue());

        if (resource.getValue() <= 0.5) {
            mesure.setDecreaseTime(0.0);
        } else {
            mesure.setDecreaseTime((resource.getValue()-0.5)/userEntity.getDecreaseRate());
        }

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
}
