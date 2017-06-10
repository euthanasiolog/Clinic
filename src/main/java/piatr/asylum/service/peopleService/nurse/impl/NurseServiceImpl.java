package piatr.asylum.service.peopleService.nurse.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.peopleEntity.users.NurseEntity;
import piatr.asylum.service.peopleService.nurse.NurseServise;

/**
 * Created by piatr on 26.05.17.
 */
@Service("nurseService")
@Transactional
public class NurseServiceImpl extends GenericServiceImpl<NurseEntity> implements NurseServise {
    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<NurseEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
