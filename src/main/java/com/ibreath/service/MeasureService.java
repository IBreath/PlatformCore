package com.ibreath.service;

import com.ibreath.resource.dto.MeasureDto;
import com.ibreath.resource.dto.PostMeasureResource;
import com.ibreath.resource.model.entity.MeasureEntity;
import com.ibreath.resource.model.entity.UserEntity;
import com.ibreath.resource.model.repository.MeasureRepository;
import com.ibreath.resource.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasureService {

    private MeasureRepository measureRepository;
    private UserRepository userRepository;

    public List<MeasureDto> getLast10Values(String userId) {

        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        List<MeasureEntity> measures = userEntity.getMeasures();
        List<MeasureDto> resources = new ArrayList<>();

        measures.forEach( e ->  {
            MeasureDto mapper = new MeasureDto();
            mapper.setId(e.getId());
            mapper.setDateTime(e.getDateTime());
            mapper.setUserEntity(e.getUserEntity());
            mapper.setValue(e.getValue());
            resources.add(mapper);
        }  );

       return resources;
    }

    public PostMeasureResource postMeasure(String userId, PostMeasureResource resource) {
        // verifier user NPE
        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));


        MeasureEntity measure = new MeasureEntity();
        measure.setUserEntity(userEntity);
        measure.setDateTime(LocalDateTime.now());
        measure.setValue(resource.getValue());

        if (resource.getValue() <= 0.5) {
            // tu peux conduire
            if (resource.getValue() > 0) {
                //update taux
                measure.setDecreaseTime(0.0);
            }
            // retourner truc sinon NPE
        } else {
            measure.setDecreaseTime((resource.getValue()-0.5)/userEntity.getDecreaseRate());
            // update taux
        }

        measureRepository.save(measure);

        return resource;
    }

    @Autowired
    public void setRepository(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
