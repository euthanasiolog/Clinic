package piatr.asylum.service.peopleService.patient;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.GenericService;

import java.time.LocalDateTime;

/**
 * Created by piatr on 26.05.17.
 */
public interface PatientService extends GenericService<PatientEntity>{
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient);
}
