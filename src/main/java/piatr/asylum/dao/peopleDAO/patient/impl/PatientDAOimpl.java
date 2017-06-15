 package piatr.asylum.dao.peopleDAO.patient.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.peopleDAO.patient.PatientDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

 /**
 * Created by piatr on 22.05.17.
 */
@Transactional
@Repository("patientDAO")
public class PatientDAOimpl extends GenericDAOImpl<PatientEntity> implements PatientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HospitalizationEntity getCurrentHospitalization(PatientEntity patient) {
        ArrayList<HospitalizationEntity> hospitalizations = new ArrayList<>(patient.getHospitalizations());
        for (HospitalizationEntity h:hospitalizations){
            if (h.getIsHospitalizationActual())
                return h;
        }
        return null;
    }

     @Override
     public PatientEntity getPatientById(long id) {
        String patientHQL = "FROM PatientEntity WHERE id=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(patientHQL);
        query.setParameter("id", id);
         return (PatientEntity) query.uniqueResult();
     }


 }
