package piatr.asylum.service.peopleService.nurse.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.UserDAO;
import piatr.asylum.entity.peopleEntity.users.NurseEntity;
import piatr.asylum.service.peopleService.UserServiceImpl;
import piatr.asylum.service.peopleService.nurse.NurseService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("nurseService")
@Transactional
public class NurseServiceImpl extends UserServiceImpl<NurseEntity> implements NurseService {
    @Override
    @Autowired
    public void setUserDAO(UserDAO<NurseEntity> userDAO){
        super.setUserDAO(userDAO);
    }
}
