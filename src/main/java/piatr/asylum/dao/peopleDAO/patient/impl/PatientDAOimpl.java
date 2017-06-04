package piatr.asylum.dao.peopleDAO.patient.impl;

import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.peopleDAO.patient.PatientGenericDAO;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAO")
public class PatientDAOimpl extends GenericDAOImpl<PatientEntity> implements PatientGenericDAO {
}
