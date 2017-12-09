package piatr.asylum.dao.hospitalizationDAO.hospitalization.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.clinicDAO.department.DepartmentDAO;
import piatr.asylum.dao.clinicDAO.departmentStamp.DepartmentStampDAO;
import piatr.asylum.dao.hospitalizationDAO.hospitalization.HospitalizationDAO;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.peopleDAO.patient.PatientDAO;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.stamps.DepartmentStamp;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;

import org.hibernate.query.Query;
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
    SessionFactory sessionFactory;

    @Autowired
    PatientDAO patientDAO;

    @Autowired
    DepartmentStampDAO departmentStampDAO;

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
    public void addDepartmentStamp(HospitalizationEntity hospitalization, String departmentName,
                                   LocalDateTime fromTime) {
        DepartmentStamp departmentStamp = new DepartmentStamp();
        departmentStamp.setDepartmentName(departmentName);
        departmentStamp.setFromTime(fromTime);
        departmentStampDAO.create(departmentStamp);
        if (hospitalization.getDepartmentStamps()!=null){
            hospitalization.getDepartmentStamps().add(departmentStamp);
            super.update(hospitalization);
        }else {
            Set<DepartmentStamp> departmentStamps = new HashSet<>();
            departmentStamps.add(departmentStamp);
            hospitalization.setDepartmentStamps(departmentStamps);
            super.update(hospitalization);
         }
    }

    @Override
    public void changeDepartment(HospitalizationEntity hospitalizationEntity, LocalDateTime dateTime,
                                 DepartmentEntity department) {
        getLastDepartmentStamp(hospitalizationEntity).setToTime(dateTime);
        addDepartmentStamp(hospitalizationEntity, department.getName(), dateTime);
        super.update(hospitalizationEntity);
    }

    @Override
    public void hospitalizationStart(PatientEntity patient, LocalDateTime startTime, DepartmentEntity department) {
        HospitalizationEntity hospitalizationEntity = new HospitalizationEntity();
        super.create(hospitalizationEntity);
        hospitalizationEntity.setStartHospitalization(startTime);
        patient.addHospitalization(hospitalizationEntity);
        hospitalizationEntity.setIsHospitalizationActual(true);
        patient.setInClinicNow(true);
        hospitalizationEntity.setPatient(patient);
        addDepartmentStamp(hospitalizationEntity, department.getName(), startTime);
        patient.setLastDepartment(department.getName());
        patientDAO.update(patient);
        super.update(hospitalizationEntity);
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
        departmentStampDAO.update(getLastDepartmentStamp(hospitalization));
        patientDAO.update(patient);
    }

    @Override
    public HospitalizationEntity getHospitalizationById(long id) {
        String hospitalizationHQL = "FROM HospitalizationEntity WHERE id=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hospitalizationHQL);
        query.setParameter("id", id);
        return (HospitalizationEntity) query.uniqueResult();
    }

    @Override
    public HospitalizationEntity getHospitalizationById(String id) {
        Long pId = new Long(id);
        return getHospitalizationById(pId);
    }
}
