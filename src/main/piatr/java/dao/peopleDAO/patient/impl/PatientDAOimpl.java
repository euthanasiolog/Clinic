package java.dao.peopleDAO.patient.impl;

import java.dao.DAO_CRUD_impl;
import java.dao.peopleDAO.patient.PatientDAO;
import java.entity.peopleEntity.PatientEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAOimpl")
public class PatientDAOimpl extends DAO_CRUD_impl<PatientEntity> implements PatientDAO{
}