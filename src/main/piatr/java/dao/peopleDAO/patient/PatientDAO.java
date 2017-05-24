package java.dao.peopleDAO.patient;

import java.dao.DAO_CRUD;
import java.entity.peopleEntity.PatientEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.entity.peopleEntity.PatientEntity;
import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */

public interface PatientDAO extends DAO_CRUD<PatientEntity>{
}
