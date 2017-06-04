package piatr.asylum.service.hospitalizationService.drug.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.hospitalizationService.drug.DrugService;
import piatr.asylum.entity.hospitalizationEntity.DrugEntity;

/**
 * Created by piatr on 26.05.17.
 */
@Service("drugService")
@Transactional
public class DrugServiceImpl extends GenericServiceImpl<DrugEntity> implements DrugService {
}
