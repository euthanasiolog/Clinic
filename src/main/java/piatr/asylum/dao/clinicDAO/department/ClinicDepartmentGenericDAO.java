package piatr.asylum.dao.clinicDAO.department;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;

import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */
public interface ClinicDepartmentGenericDAO extends GenericDAO<ClinicDepartmentEntity> {
    public List getCurrentPatients(ClinicDepartmentEntity department);
}
