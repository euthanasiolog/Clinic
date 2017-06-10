package piatr.asylum.dao.peopleDAO.patient;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 23.05.17.
 */

public interface PatientGenericDAO extends GenericDAO<PatientEntity> {
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, ClinicDepartmentEntity clinicDepartment);
    public void hospitalizationEnd(PatientEntity patient, LocalDateTime localDateTime);
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient);
}
