package piatr.asylum.service.clinicService.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.clinicDAO.department.DepartmentDAO;
import piatr.asylum.dao.clinicDAO.department.impl.DepartmentDAOimpl;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.service.clinicService.department.DepartmentService;

import java.util.List;

/**
 * Created by piatr on 26.05.17.
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl extends GenericServiceImpl<DepartmentEntity> implements DepartmentService{
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<DepartmentEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }

    @Override
    public List getCurrentPatients(DepartmentEntity department) {
        return departmentDAO.getCurrentPatients(department);
    }

    @Override
    public DepartmentEntity getDepartmentByName(String departmentName) {
        return departmentDAO.getDepartmentByName(departmentName);
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    public void addHospitalization(DepartmentEntity department, HospitalizationEntity hospitalization) {
        departmentDAO.addHospitalization(department, hospitalization);
    }
}
