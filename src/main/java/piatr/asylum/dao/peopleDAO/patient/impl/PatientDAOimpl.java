package piatr.asylum.dao.peopleDAO.patient.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.impl.HospitalizationDAOimpl;
import piatr.asylum.dao.peopleDAO.patient.PatientGenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAO")
public class PatientDAOimpl extends GenericDAOImpl<PatientEntity> implements PatientGenericDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, ClinicDepartmentEntity department) {
        HospitalizationEntity hospitalizationEntity = new HospitalizationEntity();
        hospitalizationEntity.setStartHospitalization(startTime);
        patient.addHospitalization(hospitalizationEntity);
        hospitalizationEntity.setIsHospitalizationActual(true);
        patient.setInClinicNow(true);
        patient.setLastDepartment(department.getName());
    }

    @Override
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient) {
        if (patient.getIsInClinicNow()){
            String name = patient.getLastDepartment();
            String getDepartmentHQL = "FROM ClinicDepartmentEntity WHERE name = :name";
            Query query = sessionFactory.getCurrentSession().createQuery(getDepartmentHQL);
            query.setParameter("name", name);
            return (HospitalizationEntity) query.uniqueResult();
        }else
           return null;
    }

    @Override
    public void hospitalizationEnd(PatientEntity patient, LocalDateTime endTime) {
           HospitalizationEntity hospitalization = getCurrentHospitalization(patient);
           hospitalization.setEndHospitalization(endTime);
           hospitalization.setIsHospitalizationActual(false);
           patient.setInClinicNow(false);
    }


}
