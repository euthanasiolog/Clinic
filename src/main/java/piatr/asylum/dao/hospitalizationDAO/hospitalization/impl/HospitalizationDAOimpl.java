package piatr.asylum.dao.hospitalizationDAO.hospitalization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.clinicDAO.department.DepartmentDAO;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.HospitalizationDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.peopleDAO.patient.PatientDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.clinicEntity.DepartmentStamp;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by piatr on 22.05.17.
 */
@Repository("hospitalizationDAO")
@Transactional
public class HospitalizationDAOimpl extends GenericDAOImpl<HospitalizationEntity> implements HospitalizationDAO {

    @Autowired
    private
    DepartmentDAO departmentDAO;

    @Autowired
    PatientDAO patientDAO;

    @Override
    public DepartmentStamp getLastDepartmentStamp(HospitalizationEntity hospitalization) {
        TreeSet<DepartmentStamp> departmentStamps = new TreeSet<>(hospitalization.getDepartmentStamps());
        return departmentStamps.last();
    }

    @Override
    public HospitalizationEntity getLastHospitalization(PatientEntity patient) {
        TreeSet<HospitalizationEntity> hospitalizationEntities = new TreeSet<>(patient.getHospitalizations());
        return hospitalizationEntities.last();
    }

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
    public void addDepartmentStamp(HospitalizationEntity hospitalization, String departmentName,
                                   LocalDateTime fromTime) {
        DepartmentStamp departmentStamp = new DepartmentStamp();
        departmentStamp.setDepartmentName(departmentName);
        departmentStamp.setFromTime(fromTime);
        if (hospitalization.getDepartmentStamps()!=null){
            hospitalization.getDepartmentStamps().add(departmentStamp);
        }else {
            Set<DepartmentStamp> departmentStamps = new HashSet<>();
            departmentStamps.add(departmentStamp);
         }
    }

    @Override
    public void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                                 DepartmentEntity department) {
        getLastDepartmentStamp(hospitalizationEntity).setToTime(dateTime);
        addDepartmentStamp(hospitalizationEntity, department.getName(), dateTime);
        hospitalizationEntity.getDepartments().add(department);
        departmentDAO.addHospitalization(department, hospitalizationEntity);
    }

    @Override
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, DepartmentEntity department) {
        HospitalizationEntity hospitalizationEntity = new HospitalizationEntity();
        super.create(hospitalizationEntity);
        hospitalizationEntity.setStartHospitalization(startTime);
        patient.addHospitalization(hospitalizationEntity);
        hospitalizationEntity.setIsHospitalizationActual(true);
        patient.setInClinicNow(true);
        addDepartmentStamp(hospitalizationEntity, department.getName(), startTime);
        patient.setLastDepartment(department.getName());
        patientDAO.update(patient);
        super.update(hospitalizationEntity);
        departmentDAO.addHospitalization(department, hospitalizationEntity);
        departmentDAO.update(department);
    }

    @Override
    public void hospitalizationEnd(HospitalizationEntity hospitalization,
                                   LocalDateTime endTime) {
        PatientEntity patient = hospitalization.getPatient();
        hospitalization.setEndHospitalization(endTime);
        getLastDepartmentStamp(hospitalization).setToTime(endTime);
        hospitalization.setIsHospitalizationActual(false);
        patient.setInClinicNow(false);
        patient.setLastDepartment(getLastDepartmentStamp(hospitalization).getDepartmentName());
        super.update(hospitalization);
        patientDAO.update(patient);
    }
}
