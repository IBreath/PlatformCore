package com.ibreath.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LEARNINGINDIATION")
public class LearningIndicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity userEntity;

    @OneToMany(mappedBy="learningIndicationEntity", cascade=CascadeType.ALL)
    private List<AlcoholMesure> alcoholMesure;

    @Column(name = "value")
    private String value;

    @Column(name = "pourcentage")
    private Double pourcentage;

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

    public List<AlcoholMesure> getAlcoholMesure() {
        return alcoholMesure;
    }

    public void setAlcoholMesure(List<AlcoholMesure> alcoholMesure) {
        this.alcoholMesure = alcoholMesure;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
