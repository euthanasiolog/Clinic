package java.dao.peopleDAO.patient;

import java.entity.peopleEntity.PatientEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.entity.peopleEntity.PatientEntity;
import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("patientDAO")
@Transactional
public interface PatientDAO {


    PatientEntity createPatient(PatientEntity patientEntity);

    PatientEntity getPatient(long patientId);

    void updatePatient(PatientEntity patientEntity);

    void deletePatient(PatientEntity patientEntity);

    List<PatientEntity> getPatienByDepartment(String departmentName);
}
