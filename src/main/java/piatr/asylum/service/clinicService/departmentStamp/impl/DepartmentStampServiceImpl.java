package piatr.asylum.service.clinicService.departmentStamp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import piatr.asylum.dao.GenericDAO;
import piatr.asylum.stamps.DepartmentStamp;
import piatr.asylum.service.GenericServiceImpl;
import piatr.asylum.service.clinicService.departmentStamp.DepartmentStampService;

/**
 * Created by piatr on 12.06.17.
 */
@Service("departmentStampService")
@Transactional
public class DepartmentStampServiceImpl extends GenericServiceImpl<DepartmentStamp> implements DepartmentStampService{
    @Override
    @Autowired
    protected void setGenericDAO(GenericDAO<DepartmentStamp> genericDAO){
        super.setGenericDAO(genericDAO);
    }
}
