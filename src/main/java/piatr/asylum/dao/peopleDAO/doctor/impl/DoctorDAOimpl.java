package piatr.asylum.dao.peopleDAO.doctor.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.peopleDAO.doctor.DoctorGenericDAO;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.dao.GenericDAOImpl;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("doctorDAO")
@Transactional
public class DoctorDAOimpl extends GenericDAOImpl<DoctorEntity> implements DoctorGenericDAO {
}
