package piatr.asylum.dao.clinicDAO.department.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.department.ClinicDepartmentGenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("departmentDAO")
@Transactional
public class ClinicDepartmentDAOimpl extends GenericDAOImpl<ClinicDepartmentEntity> implements ClinicDepartmentGenericDAO {
}
