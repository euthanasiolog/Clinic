package piatr.asylum.service.peopleService.doctor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.UserDAO;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.service.peopleService.UserServiceImpl;
import piatr.asylum.service.peopleService.doctor.DoctorService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("doctorService")
@Transactional
public class DoctorServiceImpl extends UserServiceImpl<DoctorEntity> implements DoctorService{
    @Override
    @Autowired
    public void setUserDAO(UserDAO<DoctorEntity> userDAO){
        super.setUserDAO(userDAO);
    }
}
