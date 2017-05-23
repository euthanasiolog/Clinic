package dao.peopleDAO.patient.impl;

import dao.peopleDAO.patient.PatientDAO;
import entity.peopleEntity.PatientEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAOimpl")
public class PatientDAOimpl implements PatientDAO{
    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    @Override
    public PatientEntity getPatient(long patientId) {
        return (PatientEntity) sessionFactory.getCurrentSession().get(PatientEntity.class, patientId);
    }

    @Override
    public void updatePatient(PatientEntity patientEntity) {
        sessionFactory.getCurrentSession().update(patientEntity);
    }

    @Override
    public void deletePatient(PatientEntity patientEntity) {
        sessionFactory.getCurrentSession().delete(patientEntity);
    }
}
