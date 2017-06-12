package piatr.asylum.dao.peopleDAO.nurse.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.UserDAOimpl;
import piatr.asylum.entity.peopleEntity.users.NurseEntity;
import piatr.asylum.dao.peopleDAO.nurse.NurseDAO;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("nurseDAO")
@Transactional
public class NurseDAOimpl extends UserDAOimpl<NurseEntity> implements NurseDAO {
}
