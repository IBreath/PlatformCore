package com.ibreath.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mUser")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "emal")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "height")
    private Double height;

    @Column(name = "Weight")
    private Double weight;

    @OneToMany(mappedBy="userEntity", cascade=CascadeType.ALL)
    private List<AlcoholMesure> alcoholMesures;

    @OneToMany(mappedBy="userEntity", cascade=CascadeType.ALL)
    private List<LearningIndicationEntity> learningIndicationEntities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<AlcoholMesure> getAlcoholMesures() {
        return alcoholMesures;
    }

    public void setAlcoholMesures(List<AlcoholMesure> alcoholMesures) {
        this.alcoholMesures = alcoholMesures;
    }

    public List<LearningIndicationEntity> getLearningIndicationEntities() {
        return learningIndicationEntities;
    }

    public void setLearningIndicationEntities(List<LearningIndicationEntity> learningIndicationEntities) {
        this.learningIndicationEntities = learningIndicationEntities;
    }
}
