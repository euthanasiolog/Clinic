package piatr.asylum.service.clinicService.clinic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.clinicEntity.ClinicEntity;
import piatr.asylum.service.clinicService.clinic.ClinicService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("clinicService")
@Transactional
public class ClinicServiceImpl extends GenericServiceImpl<ClinicEntity> implements ClinicService {
@Override
@Autowired
   protected void setGenericDAO(GenericDAO<ClinicEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
