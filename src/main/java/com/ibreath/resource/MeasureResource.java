package com.ibreath.resource;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibreath.model.entity.LearningIndicationEntity;
import com.ibreath.model.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(description = "Measure Controller")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class MeasureResource {

    @ApiModelProperty(
            "Id description"
    )
    @JsonProperty
    private long id;

    @ApiModelProperty(
            "User Entity"
    )
    @JsonIgnore
    private UserEntity userEntity;

    @ApiModelProperty(
            "Learning indication"
    )
    @JsonIgnore
    private LearningIndicationEntity learningIndicationEntity;

    @ApiModelProperty(
            "Value"
    )
    @JsonProperty
    private Double value;

    @ApiModelProperty(
            "DateTime"
    )
    @JsonProperty
    private LocalDateTime dateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LearningIndicationEntity getLearningIndicationEntity() {
        return learningIndicationEntity;
    }

    public void setLearningIndicationEntity(LearningIndicationEntity learningIndicationEntity) {
        this.learningIndicationEntity = learningIndicationEntity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}