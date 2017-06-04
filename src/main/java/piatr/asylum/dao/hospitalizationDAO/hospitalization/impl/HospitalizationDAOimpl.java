package piatr.asylum.dao.hospitalizationDAO.hospitalization.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.HospitalizationGenericDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("hospitalizationDAO")
@Transactional
public class HospitalizationDAOimpl extends GenericDAOImpl<HospitalizationEntity> implements HospitalizationGenericDAO {
}
