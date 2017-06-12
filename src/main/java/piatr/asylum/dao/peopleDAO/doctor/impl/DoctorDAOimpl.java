package piatr.asylum.dao.peopleDAO.doctor.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.UserDAOimpl;
import piatr.asylum.dao.peopleDAO.doctor.DoctorDAO;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("doctorDAO")
@Transactional
public class DoctorDAOimpl extends UserDAOimpl<DoctorEntity> implements DoctorDAO {
}
