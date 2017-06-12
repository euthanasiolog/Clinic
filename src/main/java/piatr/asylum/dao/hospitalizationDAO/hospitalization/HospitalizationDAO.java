package piatr.asylum.dao.hospitalizationDAO.hospitalization;

import org.springframework.beans.factory.annotation.Autowired;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 23.05.17.
 */
public interface HospitalizationDAO extends GenericDAO<HospitalizationEntity> {
    void addDepartment(ClinicDepartmentEntity department, HospitalizationEntity hospitalization);
    void addDepartmentStamp(HospitalizationEntity hospitalizationEntity, String departmentName,
                            LocalDateTime fromTime);
    void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                          ClinicDepartmentEntity department);
}
