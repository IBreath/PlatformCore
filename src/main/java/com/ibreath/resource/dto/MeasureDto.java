package com.ibreath.resource.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibreath.resource.model.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(description = "Measure Controller")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasureDto {

    @ApiModelProperty("Id description")
    @JsonProperty
    private Long id;

    @ApiModelProperty("Value")
    @JsonProperty
    private Double value;

    @ApiModelProperty("DateTime")
    @JsonProperty
    private LocalDateTime dateTime;

    @ApiModelProperty("Decrease Time")
    @JsonProperty
    private String decreaseTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDecreaseTime() {
        return decreaseTime;
    }

    public void setDecreaseTime(String decreaseTime) {
        this.decreaseTime = decreaseTime;
    }
}
