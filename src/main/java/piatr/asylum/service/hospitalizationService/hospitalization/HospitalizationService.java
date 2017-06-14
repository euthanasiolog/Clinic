package piatr.asylum.service.hospitalizationService.hospitalization;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.GenericService;

import java.time.LocalDateTime;

/**
 * Created by piatr on 26.05.17.
 */
public interface HospitalizationService extends GenericService<HospitalizationEntity> {
    void addDepartment(DepartmentEntity department, HospitalizationEntity hospitalization);
    void addDepartmentStamp(HospitalizationEntity hospitalizationEntity, String departmentName,
                            LocalDateTime fromTime);
    void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                          DepartmentEntity department);
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, DepartmentEntity clinicDepartment);
    public void hospitalizationEnd(PatientEntity patient, LocalDateTime localDateTime);
}
