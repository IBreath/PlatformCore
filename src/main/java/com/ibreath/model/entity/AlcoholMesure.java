package com.ibreath.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALCOHOLMESURE")
public class AlcoholMesure  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="learningIndication_id", nullable=false)
    private LearningIndicationEntity learningIndicationEntity;

    @Column(name = "value")
    private Double value;

    @Column(name = "dateTime")
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

    public LearningIndicationEntity getLearningIndicationEntity() {
        return learningIndicationEntity;
    }

    public void setLearningIndicationEntity(LearningIndicationEntity learningIndicationEntity) {
        this.learningIndicationEntity = learningIndicationEntity;
    }
}
