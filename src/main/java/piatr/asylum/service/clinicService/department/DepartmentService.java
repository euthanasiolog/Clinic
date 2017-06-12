package piatr.asylum.service.clinicService.department;

import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.service.GenericService;

import java.util.List;

/**
 * Created by piatr on 26.05.17.
 */
public interface DepartmentService extends GenericService<ClinicDepartmentEntity> {
    public List getCurrentPatients(ClinicDepartmentEntity department);
}
