package asylum.dao.peopleDAO.patient.impl;

import asylum.dao.GenericDAOImpl;
import asylum.dao.peopleDAO.patient.PatientGenericDAO;
import asylum.entity.peopleEntity.PatientEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAOimpl")
public class PatientDAOimpl extends GenericDAOImpl<PatientEntity> implements PatientGenericDAO {
}
