package piatr.asylum.service.peopleService.patient;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.GenericService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by piatr on 26.05.17.
 */
public interface PatientService extends GenericService<PatientEntity>{
    HospitalizationEntity getCurrentHospitalization(PatientEntity patient);
    PatientEntity getPatientById(long id);
    PatientEntity getPatientById(String id);
    List<PatientEntity> getAllPatirnts();
}
