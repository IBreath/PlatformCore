package com.ibreath.service;

import com.ibreath.resource.model.entity.MeasureEntity;
import com.ibreath.resource.model.entity.UserEntity;
import com.ibreath.resource.model.repository.MeasureRepository;
import com.ibreath.resource.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class AnalyseService {

    private MeasureRepository measureRepository;
    private UserRepository userRepository;

    private void updateDecreaseRate(UserEntity userEntity, Double rate, LocalDateTime measureTime) {
        MeasureEntity lastMeasure = measureRepository.findTopByUserEntityOrderByDateTime(userEntity);
        if (lastMeasure != null) {
            if (lastMeasure.getDateTime().isAfter(measureTime.minusHours(8))) {
                Double actualDecreaseRate = (lastMeasure.getValue() - rate) / ChronoUnit.MINUTES.between(lastMeasure.getDateTime(), measureTime);
                Double updatedDecreaseRate = (userEntity.getDecreaseRate() + actualDecreaseRate)/2;
                userEntity.setDecreaseRate(updatedDecreaseRate);
                userRepository.save(userEntity);
            }
        }
    }

    String getDecreaseTime(Double rate, LocalDateTime measureTime, UserEntity userEntity) {
        Double decreaseTime;
        if (rate <= 0.25) {
            decreaseTime = 0.0;
            if (rate > 0) {
                updateDecreaseRate(userEntity, rate, measureTime);
            }
        } else {
            updateDecreaseRate(userEntity, rate, measureTime);
            decreaseTime = (rate - 0.25)/userEntity.getDecreaseRate();
        }
        Long hours = Math.round(decreaseTime) / 60;
        Long minutes = Math.round(decreaseTime) % 60;
        return String.format("%d:%02d", hours, minutes);
    }

    @Autowired
    public void setMeasureRepository(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
