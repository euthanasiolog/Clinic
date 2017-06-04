package piatr.asylum.service.peopleService.doctor.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.service.peopleService.doctor.DoctorService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("doctorService")
@Transactional
public class DoctorServiceImpl extends GenericServiceImpl<DoctorEntity> implements DoctorService{
}
