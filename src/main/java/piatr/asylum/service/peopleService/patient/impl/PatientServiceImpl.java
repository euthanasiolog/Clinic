package piatr.asylum.service.peopleService.patient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.peopleDAO.patient.impl.PatientDAOimpl;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.peopleService.patient.PatientService;

import java.time.LocalDateTime;

/**
 * Created by piatr on 26.05.17.
 */
@Service("patientService")
@Transactional
public class PatientServiceImpl extends GenericServiceImpl<PatientEntity> implements PatientService {
    @Autowired
    PatientDAOimpl patientDAO;

    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<PatientEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }

    @Override
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, ClinicDepartmentEntity clinicDepartment) {
        patientDAO.hospitalizationStart(patient, startTime, clinicDepartment);
    }

    @Override
    public void hospitalizationEnd(PatientEntity patient, LocalDateTime localDateTime) {
        patientDAO.hospitalizationEnd(patient, localDateTime);
    }

    @Override
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient) {
        return patientDAO.getCurrentHospitalization(patient);
    }
}
