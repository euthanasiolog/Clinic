package piatr.asylum.dao.clinicDAO.clinic;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicEntity;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by piatr on 23.05.17.
 */
public interface ClinicDAO extends GenericDAO<ClinicEntity> {
    public Set<DepartmentEntity> getDepartments(ClinicEntity clinic);
}
