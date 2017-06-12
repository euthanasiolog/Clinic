package piatr.asylum.dao.hospitalizationDAO.hospitalization.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.HospitalizationDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.clinicEntity.DepartmentStamp;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("hospitalizationDAO")
@Transactional
public class HospitalizationDAOimpl extends GenericDAOImpl<HospitalizationEntity> implements HospitalizationDAO {

    @Override
    public void addDepartment(DepartmentEntity department, HospitalizationEntity hospitalization) {
        if (hospitalization.getDepartments()!=null){
        hospitalization.getDepartments().add(department);
        } else {
            Set<DepartmentEntity> departmentEntities = new TreeSet<>();
            departmentEntities.add(department);
        }
    }

    @Override
    public void addDepartmentStamp(HospitalizationEntity hospitalization, String departmentName, LocalDateTime fromTime) {
        DepartmentStamp departmentStamp = new DepartmentStamp();
        departmentStamp.setDepartmentName(departmentName);
        departmentStamp.setFromTime(fromTime);
        if (hospitalization.getDepartmentStamps()!=null){
            hospitalization.getDepartmentStamps().add(departmentStamp);
        }else {
            Set<DepartmentStamp> departmentStamps = new TreeSet<>();
            departmentStamps.add(departmentStamp);

        }
    }

    @Override
    public void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                                 DepartmentEntity department) {
        TreeSet<DepartmentStamp> departmentStamps = new TreeSet<>(hospitalizationEntity.getDepartmentStamps());
        departmentStamps.last().setToTime(dateTime);
        addDepartmentStamp(hospitalizationEntity, department.getName(), dateTime);
        hospitalizationEntity.getDepartments().add(department);
    }


}
