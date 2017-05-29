package java.abstractClasses;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.entity.clinicEntity.ClinicDepartmentEntity;
import java.io.Serializable;

/**
 * Created by piatr on 17.05.17.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClinicEmployee extends User implements Serializable{
    @Column
    ClinicDepartmentEntity department;
}
