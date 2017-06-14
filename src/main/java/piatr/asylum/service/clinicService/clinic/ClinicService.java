package piatr.asylum.service.clinicService.clinic;

import piatr.asylum.entity.clinicEntity.ClinicEntity;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.service.GenericService;

import java.util.Set;

/**
 * Created by piatr on 26.05.17.
 */
public interface ClinicService extends GenericService<ClinicEntity> {
    public Set<DepartmentEntity> departments(ClinicEntity clinic);
}
