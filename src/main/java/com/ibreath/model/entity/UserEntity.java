package com.ibreath.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "c_User")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userEntity",targetEntity = MesureEntity.class)
    private Set<MesureEntity> mesures = new HashSet<>();

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

    @Column(name = "decreaseRate")
    private Double decreaseRate;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<MesureEntity> getAlcoholMesures() {
        return mesures;
    }

    public Set<MesureEntity> getMesures() {
        return mesures;
    }

    public UserEntity setMesures(Set<MesureEntity> mesures) {
        this.mesures = mesures;
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
}
