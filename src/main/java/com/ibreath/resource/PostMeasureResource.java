package com.ibreath.resource;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Measure Controller")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class PostMeasureResource {

    @ApiModelProperty(
            "Id description"
    )
    @JsonProperty
    private long learningIndication;

    @ApiModelProperty(
            "Value"
    )
    @JsonProperty
    private Double value;

    public long getLearningIndication() {
        return learningIndication;
    }

    public void setLearningIndication(long learningIndication) {
        this.learningIndication = learningIndication;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
