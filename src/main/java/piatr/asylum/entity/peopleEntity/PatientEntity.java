package piatr.asylum.entity.peopleEntity;


import piatr.asylum.abstractClasses.Human;

import javax.persistence.*;

import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

import java.util.Set;

/**
 * Created by piatr on 16.05.17.
 * тут все пациенты больницы
 * и у каждого есть свой подчиненный список госпитализаций, их может быть много
 */
@Entity
@Table(name = "patient")
public class PatientEntity extends Human {

    @Column
    @OneToMany
    private Set<HospitalizationEntity> hospitalizations;

}
