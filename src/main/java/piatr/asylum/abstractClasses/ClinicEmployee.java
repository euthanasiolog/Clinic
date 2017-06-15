package piatr.asylum.abstractClasses;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;

import java.io.Serializable;

/**
 * Created by piatr on 17.05.17.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClinicEmployee extends User implements Serializable{
    @Column
    private DepartmentEntity department;

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
