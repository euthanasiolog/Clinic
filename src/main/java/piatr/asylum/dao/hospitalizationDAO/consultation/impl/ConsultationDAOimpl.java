package piatr.asylum.dao.hospitalizationDAO.consultation.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.hospitalizationDAO.consultation.ConsultationDAO;
import piatr.asylum.entity.hospitalizationEntity.ConsultationEntity;

/**
 * Created by piatr on 07.06.17.
 */
@Repository("consultationDAO")
@Transactional
public class ConsultationDAOimpl extends GenericDAOImpl<ConsultationEntity> implements ConsultationDAO {
}
