package com.ibreath.resource.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibreath.annotation.PasswordMatches;
import com.ibreath.annotation.ValidEmail;
import com.ibreath.enumeration.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(description = "User Controller")
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@PasswordMatches
public class UserDto {

    @ApiModelProperty("Id of an user")
    private Long id;

    @ApiModelProperty("Firstname")
    @JsonProperty
    @NotNull
    private String firstname;

    @ApiModelProperty("LastName")
    @JsonProperty
    @NotNull
    private String lastname;

    @ApiModelProperty("Email")
    @JsonProperty
    @NotNull
    @ValidEmail
    private String email;

    @ApiModelProperty("Birth Date")
    @JsonProperty
    @NotNull
    private LocalDateTime birthDate;

    @ApiModelProperty("Height")
    @JsonProperty
    @NotNull
    private Double height;

    @ApiModelProperty("Weight")
    @JsonProperty
    @NotNull
    private Double weight;

    @ApiModelProperty("Gender")
    @JsonProperty
    @NotNull
    private GenderEnum gender;

    @ApiModelProperty("Decrease Rate")
    @JsonProperty
    private Double decreaseRate;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public UserDto setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public UserDto setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public UserDto setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserDto setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public Double getDecreaseRate() {
        return decreaseRate;
    }

    public UserDto setDecreaseRate(Double decreaseRate) {
        this.decreaseRate = decreaseRate;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public UserDto setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }
}
