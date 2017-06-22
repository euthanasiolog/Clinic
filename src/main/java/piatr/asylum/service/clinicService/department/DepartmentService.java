package piatr.asylum.service.clinicService.department;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.service.GenericService;

import java.util.List;

/**
 * Created by piatr on 26.05.17.
 */
public interface DepartmentService extends GenericService<DepartmentEntity> {
    public List getCurrentPatients(DepartmentEntity department);
    public DepartmentEntity getDepartmentByName(String departmentName);
    public List<DepartmentEntity> getAllDepartments();
    public void addHospitalization(DepartmentEntity department, HospitalizationEntity hospitalization);
}
