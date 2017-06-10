package piatr.asylum.dao.hospitalizationDAO.hospitalization.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.HospitalizationDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.entity.clinicEntity.ClinicDepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("hospitalizationDAO")
@Transactional
public class HospitalizationDAOimpl extends GenericDAOImpl<HospitalizationEntity> implements HospitalizationDAO {

    @Override
    public void addDepartment(ClinicDepartmentEntity department, HospitalizationEntity hospitalization) {
        if (hospitalization.getDepartments()!=null){
        Set<ClinicDepartmentEntity> departmentEntities = hospitalization.getDepartments();
        departmentEntities.add(department);

        } else {
            Set<ClinicDepartmentEntity> departmentEntities = new TreeSet<>();
            departmentEntities.add(department);
        }
    }
}
