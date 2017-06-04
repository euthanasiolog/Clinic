package piatr.asylum.service.hospitalizationService.consultation.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.entity.hospitalizationEntity.ConsultationEntity;
import piatr.asylum.service.hospitalizationService.consultation.ConsultationService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("consultationService")
@Transactional
public class ConsultationServiceImpl extends GenericServiceImpl<ConsultationEntity> implements ConsultationService{
}
