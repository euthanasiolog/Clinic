package piatr.asylum.dao.peopleDAO.patient;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */

public interface PatientDAO extends GenericDAO<PatientEntity> {
    HospitalizationEntity getCurrentHospitalization(PatientEntity patient);
    PatientEntity getPatientById(long id);
    PatientEntity getPatientById(String id);
    List<PatientEntity> getAllPatients();
}
