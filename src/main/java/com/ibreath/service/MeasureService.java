package com.ibreath.service;

import com.ibreath.resource.dto.MeasureDto;
import com.ibreath.resource.mapper.MeasureMapper;
import com.ibreath.resource.model.entity.MeasureEntity;
import com.ibreath.resource.model.entity.UserEntity;
import com.ibreath.resource.model.repository.MeasureRepository;
import com.ibreath.resource.model.repository.UserRepository;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasureService {

    private MeasureRepository measureRepository;
    private UserRepository userRepository;
    private AnalyseService analyseService;
    private MeasureMapper measureMapper;

    public List<MeasureDto> getLast10Values(String userId) {

        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));
        List<MeasureEntity> measures = userEntity.getMeasures();
        List<MeasureDto> resources = new ArrayList<>();

        measures.forEach( e ->  {
            MeasureDto mapper = new MeasureDto();
            mapper.setId(e.getId());
            mapper.setDateTime(e.getDateTime());
            mapper.setValue(e.getValue());
            resources.add(mapper);
        }  );

       return resources;
    }

    public MeasureDto postMeasure(String userId, MeasureDto resource) {
        // verifier user NPE
        UserEntity userEntity = userRepository.findOne(Long.valueOf(userId));

        MeasureEntity measure = measureMapper.mapDtoToEntity(resource);
        measure.setUserEntity(userEntity);
        LocalDateTime measureTime = LocalDateTime.now();
        measure.setDateTime(measureTime);
        measure.setDecreaseTime(analyseService.getDecreaseTime(resource.getValue(), measureTime, userEntity));

        measure = measureRepository.save(measure);

        return measureMapper.mapEntityToDto(measure);
    }

    @Autowired
    public void setMeasureRepository(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAnalyseService(AnalyseService analyseService) {
        this.analyseService = analyseService;
    }

    @Autowired
    public void setMeasureMapper(MeasureMapper measureMapper) {
        this.measureMapper = measureMapper;
    }
}
