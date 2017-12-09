package piatr.asylum.entity.hospitalizationEntity;




import piatr.asylum.abstractClasses.BaseEntity;
import piatr.asylum.stamps.DepartmentStamp;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by piatr on 16.05.17.
 * тут все госпитализации
 * у пациента их может быть много
 * и только одна активная(если он в настоящий момент лежит в больнице)
 * у госпитализации планирую подчиненные списки: лекарства, консультации, анализы, процедуры (пока так, может и больше придеться)
 */
@Entity
@Table(name = "hospitalization")
public class  HospitalizationEntity extends BaseEntity implements Comparable{

    @JoinColumn
    @ManyToOne
    private PatientEntity patient;

    //дата поступления
    @Column
    private LocalDateTime startHospitalization;

    //дата выписки
    @Column
    private LocalDateTime endHospitalization;

    //лежит ли пациент прямо сейчас
    private boolean isHospitalizationActual = false;

    //список лекарств(типа лист назначений)
    @JoinColumn(name = "drug_list")
    @OneToMany
    private Set<DrugEntity> drugList;

    //список консультаций
    @JoinColumn(name = "consult_list")
    @OneToMany
    private Set<ConsultationEntity> consultList;

    @JoinColumn(name = "department_stamps")
    @OneToMany
    private Set<DepartmentStamp> departmentStamps;

    public Set<DepartmentStamp> getDepartmentStamps() {
        return departmentStamps;
    }

    public void setDepartmentStamps(Set<DepartmentStamp> departmentStamps) {
        this.departmentStamps = departmentStamps;
    }

    public boolean getIsHospitalizationActual() {
        return isHospitalizationActual;
    }

    public void setIsHospitalizationActual(boolean hospitalizationActual) {
        isHospitalizationActual = hospitalizationActual;
    }

    public Set<ConsultationEntity> getConsultList() {
        return consultList;
    }

    public void setConsultList(Set<ConsultationEntity> consultList) {
        this.consultList = consultList;
    }

    public LocalDateTime getStartHospitalization() {
        return startHospitalization;
    }

    public void setStartHospitalization(LocalDateTime startHospitalization) {
        this.startHospitalization = startHospitalization;
    }

    public LocalDateTime getEndHospitalization() {
        return endHospitalization;
    }

    public void setEndHospitalization(LocalDateTime endHospitalization) {
        this.endHospitalization = endHospitalization;
    }



    public Set<DrugEntity> getDrugList() {
        return drugList;
    }

    public void setDrugList(Set<DrugEntity> drugList) {
        this.drugList = drugList;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    @Override
    public int compareTo(Object o) {
        HospitalizationEntity hospitalization = (HospitalizationEntity)o;
        if (this.endHospitalization==null){
            return 1;
        }
        return this.endHospitalization.compareTo(hospitalization.endHospitalization);
    }
}
