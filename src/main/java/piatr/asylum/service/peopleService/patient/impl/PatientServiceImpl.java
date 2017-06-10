package piatr.asylum.service.peopleService.patient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.peopleService.patient.PatientService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("patientService")
@Transactional
public class PatientServiceImpl extends GenericServiceImpl<PatientEntity> implements PatientService {
    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<PatientEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
