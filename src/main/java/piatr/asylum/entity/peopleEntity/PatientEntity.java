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
    private String lastDepartment;

    public String getLastDepartment() {
        return lastDepartment;
    }

    @Column
    private boolean isInClinicNow;

    public void setName(String name){

    }

    public boolean getIsInClinicNow() {
        return isInClinicNow;
    }

    public void setInClinicNow(boolean inClinicNow) {
        isInClinicNow = inClinicNow;
    }

    public void setLastDepartment(String lastDepartment) {
        this.lastDepartment = lastDepartment;
    }

    @JoinColumn(name = "patient_hospitalization")
    @OneToMany
    private Set<HospitalizationEntity> hospitalizations;

    public Set<HospitalizationEntity> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(Set<HospitalizationEntity> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public void addHospitalization(HospitalizationEntity hospitalization){
        hospitalizations.add(hospitalization);
    }
}
