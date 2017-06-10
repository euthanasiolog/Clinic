package piatr.asylum.dao.hospitalizationDAO.hospitalization;

import org.springframework.beans.factory.annotation.Autowired;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

/**
 * Created by piatr on 23.05.17.
 */
public interface HospitalizationDAO extends GenericDAO<HospitalizationEntity> {
    public void addDepartment(ClinicDepartmentEntity department, HospitalizationEntity hospitalization);
}
