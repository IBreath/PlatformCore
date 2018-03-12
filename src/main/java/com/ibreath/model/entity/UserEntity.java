package com.ibreath.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy="userEntity", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MesureEntity> alcoholMesures = new HashSet<>();

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

    public long getId() {
        return id;
    }

    public UserEntity setId(long id) {
        this.id = id;
        return this;
    }

    public Set<MesureEntity> getAlcoholMesures() {
        return alcoholMesures;
    }

    public UserEntity setAlcoholMesures(Set<MesureEntity> alcoholMesures) {
        this.alcoholMesures = alcoholMesures;
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
