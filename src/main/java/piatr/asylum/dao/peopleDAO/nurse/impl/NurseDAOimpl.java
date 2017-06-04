package piatr.asylum.dao.peopleDAO.nurse.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.entity.peopleEntity.users.NurseEntity;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.peopleDAO.nurse.NurseGenericDAO;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("nurseDAO")
@Transactional
public class NurseDAOimpl extends GenericDAOImpl<NurseEntity> implements NurseGenericDAO {
}
