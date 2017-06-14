package piatr.asylum.dao.clinicDAO.clinic.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.clinic.ClinicDAO;
import piatr.asylum.entity.clinicEntity.ClinicEntity;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;

import java.util.Set;

/**
 * Created by piatr on 23.05.17.
 */
@Repository("clinicDAO")
@Transactional
public class ClinicDAOimpl extends GenericDAOImpl<ClinicEntity> implements ClinicDAO {

    @Override
    public Set<DepartmentEntity> getDepartments(ClinicEntity clinic) {
        return clinic.getDepartments();
    }
}
