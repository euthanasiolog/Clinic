package piatr.asylum.service.hospitalizationService.hospitalization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.impl.HospitalizationDAOimpl;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.hospitalizationService.hospitalization.HospitalizationService;

import java.time.LocalDateTime;

/**
 * Created by piatr on 26.05.17.
 */
@Service("hospitalizationService")
@Transactional
public class HospitalizationServiceImpl extends GenericServiceImpl<HospitalizationEntity> implements HospitalizationService{
    @Autowired
    HospitalizationDAOimpl hospitalizationDAO;

    @Autowired
    @Override
    protected void setGenericDAO(GenericDAO<HospitalizationEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }

    @Override
    public void addDepartment(ClinicDepartmentEntity department, HospitalizationEntity hospitalization) {
        hospitalizationDAO.addDepartment(department, hospitalization);
    }

    @Override
    public void addDepartmentStamp(HospitalizationEntity hospitalizationEntity, String departmentName, LocalDateTime fromTime) {
        hospitalizationDAO.addDepartmentStamp(hospitalizationEntity, departmentName, fromTime);
    }

    @Override
    public void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime, ClinicDepartmentEntity department) {
        hospitalizationDAO.changeDepartment(hospitalizationEntity, dateTime, department);
    }
}