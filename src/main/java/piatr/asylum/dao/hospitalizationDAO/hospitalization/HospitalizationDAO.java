package piatr.asylum.dao.hospitalizationDAO.hospitalization;

import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.stamps.DepartmentStamp;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 23.05.17.
 */
public interface HospitalizationDAO extends GenericDAO<HospitalizationEntity> {
    public DepartmentStamp getLastDepartmentStamp(HospitalizationEntity hospitalization);
    public HospitalizationEntity getLastHospitalization(PatientEntity patient);
//    void addDepartment(DepartmentEntity department, HospitalizationEntity hospitalization);
    void addDepartmentStamp(HospitalizationEntity hospitalizationEntity, String departmentName,
                            LocalDateTime fromTime);
    void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                          DepartmentEntity department);
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, DepartmentEntity clinicDepartment);
    public void hospitalizationEnd(HospitalizationEntity hospitalization, LocalDateTime localDateTime);
    HospitalizationEntity getHospitalizationById(long id);
    HospitalizationEntity getHospitalizationById(String id);
}
