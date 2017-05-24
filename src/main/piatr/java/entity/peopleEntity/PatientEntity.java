package java.entity.peopleEntity;

import abstractClasses.Human;
import entity.hospitalizationEntity.HospitalizationEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.abstractClasses.Human;
import java.entity.hospitalizationEntity.HospitalizationEntity;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by piatr on 16.05.17.
 * тут все пациенты больницы
 * и у каждого есть свой подчиненный список госпитализаций, их может быть много
 */
@Entity
@Table(name = "patient")
public class PatientEntity extends Human{

    @Column
    @ManyToOne
    private Set<HospitalizationEntity> hospitalizations;


}
