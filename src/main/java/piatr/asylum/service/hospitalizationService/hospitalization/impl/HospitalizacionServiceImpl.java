package piatr.asylum.service.hospitalizationService.hospitalization.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.hospitalizationService.hospitalization.HospitalizationService;

/**
 * Created by piatr on 26.05.17.
 */
@Service("hospitalizationService")
@Transactional
public class HospitalizacionServiceImpl extends GenericServiceImpl<HospitalizationEntity> implements HospitalizationService{
}
