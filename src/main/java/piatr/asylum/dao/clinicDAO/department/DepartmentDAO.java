package piatr.asylum.dao.clinicDAO.department;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;

import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */
public interface DepartmentDAO extends GenericDAO<DepartmentEntity> {
    public List getCurrentPatients(DepartmentEntity department);
    public DepartmentEntity getDepartmentByName(String departmentName);
    public List<DepartmentEntity> getAllDepartments();
    public List<DepartmentEntity> getUserDepartments(String login);
}
