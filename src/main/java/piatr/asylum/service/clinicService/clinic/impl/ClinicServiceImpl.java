package piatr.asylum.service.clinicService.clinic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.clinicDAO.clinic.ClinicDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.clinicEntity.ClinicEntity;
import piatr.asylum.service.clinicService.clinic.ClinicService;

import java.util.Set;

/**
 * Created by piatr on 26.05.17.
 */
@Service("clinicService")
@Transactional
public class ClinicServiceImpl extends GenericServiceImpl<ClinicEntity> implements ClinicService {

    @Autowired
    private ClinicDAO clinicDAO;

    @Override
    @Autowired
   protected void setGenericDAO(GenericDAO<ClinicEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }

    @Override
    public Set<DepartmentEntity> departments(ClinicEntity clinic) {
        return clinicDAO.getDepartments(clinic);
    }
}
