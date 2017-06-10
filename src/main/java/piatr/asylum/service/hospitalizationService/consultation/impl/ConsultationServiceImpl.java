package piatr.asylum.service.hospitalizationService.consultation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.hospitalizationEntity.ConsultationEntity;
import piatr.asylum.service.hospitalizationService.consultation.ConsultationService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("consultationService")
@Transactional
public class ConsultationServiceImpl extends GenericServiceImpl<ConsultationEntity> implements ConsultationService{
    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<ConsultationEntity> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
