package piatr.asylum.dao.hospitalizationDAO.drug.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.entity.hospitalizationEntity.DrugEntity;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.hospitalizationDAO.drug.DrugGenericDAO;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("drugDAO")
@Transactional
public class DrugDAOimpl extends GenericDAOImpl<DrugEntity> implements DrugGenericDAO {
}
