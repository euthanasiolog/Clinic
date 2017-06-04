package piatr.asylum.dao.clinicDAO.clinic.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.clinic.ClinicGenericDAO;
import piatr.asylum.entity.clinicEntity.ClinicEntity;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("clinicDAO")
@Transactional
public class ClinicDAOimpl extends GenericDAOImpl<ClinicEntity> implements ClinicGenericDAO {
}
