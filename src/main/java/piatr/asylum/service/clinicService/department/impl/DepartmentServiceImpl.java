package piatr.asylum.service.clinicService.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.service.clinicService.department.DepartmentService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends GenericServiceImpl<ClinicDepartmentEntity> implements DepartmentService{
    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<ClinicDepartmentEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
