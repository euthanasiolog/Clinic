package java.entity.hospitalizationEntity;




import javax.persistence.*;
import java.abstractClasses.BaseEntity;
import java.entity.clinicEntity.ClinicDepartmentEntity;
import java.io.Serializable;
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

    @Column
    @Id
    @GeneratedValue
    long id;

    //дата поступления
    @Column
    LocalDateTime startHospitalization;

    //дата выписки
    @Column
    LocalDateTime endHospitalization;

    //список госпитализаций. пациента могут переводить из
    // отделения в отделение, поэтому многие ко многим
    @Column
    @ManyToMany
    @JoinTable(name = "HOSP_DEP",
    joinColumns = {@JoinColumn(name = "HOSP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "DEP_ID")})
    private Set<ClinicDepartmentEntity> departments;

    @Column
    @ManyToOne
    private Set<DrugEntity> drugList;

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
