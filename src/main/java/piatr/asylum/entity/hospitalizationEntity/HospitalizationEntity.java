package piatr.asylum.entity.hospitalizationEntity;




import piatr.asylum.abstractClasses.BaseEntity;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.clinicEntity.DepartmentStamp;

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

    //список лекарств(типа лист назначений)
    @JoinColumn(name = "drug_list")
    @OneToMany
    private Set<DrugEntity> drugList;

    //список консультаций
    @JoinColumn(name = "consult_list")
    @OneToMany
    private Set<ConsultationEntity> consultList;

    //список отметок отделений. что бы можно было посмотреть, с какого по какое время
    //и в каком отделении в течение данной госпитализации находился пациент. Изначально для этого задумывался
    //просто список отделений, но вышла неувязка - время поступления и время убытия не относятся к отделению,
    // это относится к пациенту, делать такие поля в классе отделения нелогично, да и в одном отделении пациент
    //может быть более одного раза, поэтому я создал класс-костыль, в нем как раз имя отделения и время
    // нахождения в нем. По имени отделения можно найти само отделение, и посмотреть информацию о нём.
    // Зачем тогда список отделений, который выше, я не знаю, но пусть пока будет) никогда не знаешь, что тебе
    // может понадобиться вскоре, когда я начинал этот проект, и в мыслях не было такой структуры, мне это казалось
    // примитивнейшей вещью...
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
