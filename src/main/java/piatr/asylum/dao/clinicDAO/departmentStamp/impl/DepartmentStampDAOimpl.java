package piatr.asylum.dao.clinicDAO.departmentStamp.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAOImpl;
import piatr.asylum.dao.clinicDAO.departmentStamp.DepartmentStampDAO;
import piatr.asylum.stamps.DepartmentStamp;

/**
 * Created by piatr on 12.06.17.
 */
@Repository("departmentStampDAO")
@Transactional
public class DepartmentStampDAOimpl extends GenericDAOImpl<DepartmentStamp> implements DepartmentStampDAO {
}
