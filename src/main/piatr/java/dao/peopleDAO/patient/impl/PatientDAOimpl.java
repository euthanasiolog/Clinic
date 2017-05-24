package java.dao.peopleDAO.patient.impl;

import java.dao.peopleDAO.patient.PatientDAO;
import java.entity.peopleEntity.PatientEntity;
import java.util.List;

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
    public PatientEntity createPatient(PatientEntity patientEntity) {
        return patientEntity;
    }

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

    @Override
    public List<PatientEntity> getPatienByDepartment(String departmentName) {
        return null;
    }
}
