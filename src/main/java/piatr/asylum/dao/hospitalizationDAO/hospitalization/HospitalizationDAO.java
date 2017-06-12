package piatr.asylum.dao.hospitalizationDAO.hospitalization;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 23.05.17.
 */
public interface HospitalizationDAO extends GenericDAO<HospitalizationEntity> {
    void addDepartment(DepartmentEntity department, HospitalizationEntity hospitalization);
    void addDepartmentStamp(HospitalizationEntity hospitalizationEntity, String departmentName,
                            LocalDateTime fromTime);
    void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                          DepartmentEntity department);
}
