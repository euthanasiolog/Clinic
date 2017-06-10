package piatr.asylum.dao.clinicDAO.department.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.department.ClinicDepartmentGenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.util.List;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("departmentDAO")
@Transactional
public class ClinicDepartmentDAOimpl extends GenericDAOImpl<ClinicDepartmentEntity> implements ClinicDepartmentGenericDAO {

    @Autowired
    private
    SessionFactory sessionFactory;

    @Override
    public List<PatientEntity> getCurrentPatients(ClinicDepartmentEntity department) {
        String departmentName = department.getName();
        String patientsHSQL = "FROM PatientEntity WHERE isInClinicNow = true AND lastDepartment = :departmentName";
        Query query = sessionFactory.getCurrentSession().createQuery(patientsHSQL);
        query.setParameter("departmentName", departmentName);
        List patients = query.list();
        return patients;
    }
}
