package piatr.asylum.entity.hospitalizationEntity;


import piatr.asylum.enumerations.DrugType;
import piatr.asylum.enumerations.DrugUseType;

import javax.persistence.*;

import piatr.asylum.abstractClasses.BaseEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * Created by piatr on 21.05.17.
 */
@Entity
@Table(name = "drug")
public class DrugEntity extends BaseEntity{

    @Column
    private
    String name;

    //доза лекарства в граммах или миллиграммах
    @Column
    private
    double dose;

    //доза лекарства в количестве таблеток(или других форм)
    @Column
    int numberOfDrug;

    //дата назначения
    @Column
    LocalDateTime startTime;

    //дата отмены
    @Column
    LocalDateTime endTime;

    //время приема
    @Column
    LocalTime useTime;

    //тип лекарства
    @Column
    DrugType drugType;

    //тип приема лекарства
    @Column
    DrugUseType drugUseType;

    public DrugEntity() {
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }

    public DrugUseType getDrugUseType() {
        return drugUseType;
    }

    public void setDrugUseType(DrugUseType drugUseType) {
        this.drugUseType = drugUseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getUseTime() {
        return useTime;
    }

    public void setUseTime(LocalTime useTime) {
        this.useTime = useTime;
    }



    public int getNumberOfDrug() {
        return numberOfDrug;
    }

    public void setNumberOfDrug(int numberOfDrug) {
        this.numberOfDrug = numberOfDrug;
    }

}
