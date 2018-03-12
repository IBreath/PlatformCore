package com.ibreath.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mesure")
public class MesureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity userEntity;

    @Column(name = "value")
    private Double value;

    @Column(name = "decreaseTime")
    private Double decreaseTime;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    public long getId() {
        return id;
    }

    public MesureEntity setId(long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public MesureEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public MesureEntity setValue(Double value) {
        this.value = value;
        return this;
    }

    public Double getDecreaseTime() {
        return decreaseTime;
    }

    public MesureEntity setDecreaseTime(Double decreaseTime) {
        this.decreaseTime = decreaseTime;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public MesureEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
