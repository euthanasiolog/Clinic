package piatr.asylum.entity.hospitalizationEntity;




import piatr.asylum.abstractClasses.BaseEntity;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;

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
public class HospitalizationEntity extends BaseEntity {

    //дата поступления
    @Column
    private LocalDateTime startHospitalization;

    //дата выписки
    @Column
    private LocalDateTime endHospitalization;

    public HospitalizationEntity() {
    }

    //лежит ли пациент прямо сейчас
    private boolean isHospitalizationActual = false;

    //список госпитализаций. пациента могут переводить из
    // отделения в отделение, поэтому многие ко многим
    @Column
    @ManyToMany
    @JoinTable(name = "HOSP_DEP",
    joinColumns = {@JoinColumn(name = "HOSP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "DEP_ID")})
    private Set<ClinicDepartmentEntity> departments;

    public boolean getIsHospitalizationActual() {
        return isHospitalizationActual;
    }

    public void setIsHospitalizationActual(boolean hospitalizationActual) {
        isHospitalizationActual = hospitalizationActual;
    }

    //список лекарств(типа лист назначений)
    @JoinColumn(name = "drug_list")
    @OneToMany
    private Set<DrugEntity> drugList;

    //список консультаций
    @JoinColumn(name = "consult_list")
    @OneToMany
    private Set<ConsultationEntity> consultList;

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

    public Set<ClinicDepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<ClinicDepartmentEntity> departments) {
        this.departments = departments;
    }

    public Set<DrugEntity> getDrugList() {
        return drugList;
    }

    public void setDrugList(Set<DrugEntity> drugList) {
        this.drugList = drugList;
    }
}
