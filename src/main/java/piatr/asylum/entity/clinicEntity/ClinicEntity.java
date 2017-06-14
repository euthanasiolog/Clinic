package piatr.asylum.entity.clinicEntity;

import javax.persistence.*;

import piatr.asylum.abstractClasses.BaseEntity;

import java.util.Set;

/**
 * Created by piatr on 24.05.17.
 */
@Entity
@Table(name = "clinic")
public class ClinicEntity extends BaseEntity{
    @Column
    private String name;

    @Column
    private String adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @JoinColumn(name = "departments")
    @OneToMany
    private Set<DepartmentEntity> departments;

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentEntity> departments) {
        this.departments = departments;
    }
}
