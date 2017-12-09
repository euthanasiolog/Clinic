package piatr.asylum.dao.clinicDAO.department.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.department.DepartmentDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("departmentDAO")
@Transactional
public class DepartmentDAOimpl extends GenericDAOImpl<DepartmentEntity> implements DepartmentDAO {

    @Autowired
    private
    SessionFactory sessionFactory;

    @Override
    public List<PatientEntity> getCurrentPatients(DepartmentEntity department) {
        String departmentName = department.getName();
        String patientsHSQL = "FROM PatientEntity WHERE isInClinicNow = true AND lastDepartment = :departmentName";
        Query query = sessionFactory.getCurrentSession().createQuery(patientsHSQL);
        query.setParameter("departmentName", departmentName);
        return query.list();
    }

    @Override
    public DepartmentEntity getDepartmentByName(String departmentName) {
        String depHQL = "FROM DepartmentEntity WHERE name = :name";
        Query query = sessionFactory.getCurrentSession().createQuery(depHQL);
        query.setParameter("name", departmentName);
        return (DepartmentEntity) query.uniqueResult();
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        String depsHQL = "FROM DepartmentEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(depsHQL);
        return  query.list();
    }

    @Override
    public List<DepartmentEntity> getUserDepartments(String login) {
        return null;
    }

}
