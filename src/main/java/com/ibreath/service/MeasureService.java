package com.ibreath.service;

import com.ibreath.model.entity.MesureEntity;
import com.ibreath.model.entity.UserEntity;
import com.ibreath.model.repository.MesureRepository;
import com.ibreath.model.repository.UserRepository;
import com.ibreath.resource.GetMeasureResource;
import com.ibreath.resource.PostMeasureResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MeasureService {

    private MesureRepository mesureRepository;
    private UserRepository userRepository;

    public List<GetMeasureResource> getLast10Values(String userId) {

        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        Set<MesureEntity> alcoholMesures = userEntity.getAlcoholMesures();
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

        mesureRepository.save(mesure);

        return resource;
    }

    @Autowired
    public void setRepository(MesureRepository mesureRepository) {
        this.mesureRepository = mesureRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
