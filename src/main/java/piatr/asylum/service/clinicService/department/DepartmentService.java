package piatr.asylum.service.clinicService.department;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.service.GenericService;

import java.util.List;

/**
 * Created by piatr on 26.05.17.
 */
public interface DepartmentService extends GenericService<DepartmentEntity> {
    public List getCurrentPatients(DepartmentEntity department);
}
