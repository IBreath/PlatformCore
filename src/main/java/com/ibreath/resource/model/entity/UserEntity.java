package com.ibreath.resource.model.entity;

import com.ibreath.enumeration.GenderEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "c_User")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity",targetEntity = MeasureEntity.class)
    private List<MeasureEntity> measures;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthDate")
    private LocalDateTime birthDate;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "decreaseRate")
    private Double decreaseRate;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public List<MeasureEntity> getMeasures() {
        return measures;
    }

    public UserEntity setMeasures(List<MeasureEntity> measures) {
        this.measures = measures;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public UserEntity setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public UserEntity setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public UserEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getDecreaseRate() {
        return decreaseRate;
    }

    public UserEntity setDecreaseRate(Double decreaseRate) {
        this.decreaseRate = decreaseRate;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public UserEntity setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
