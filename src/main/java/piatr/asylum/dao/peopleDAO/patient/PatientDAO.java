package piatr.asylum.dao.peopleDAO.patient;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 23.05.17.
 */

public interface PatientDAO extends GenericDAO<PatientEntity> {
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient);
    public PatientEntity getPatientById(long id);
}
