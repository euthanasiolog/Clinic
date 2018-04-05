package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.clinicService.department.DepartmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 04.04.18.
 */
@RestController
public class AjaxController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/getPatientsAjax", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<PatientEntity> patients (@RequestParam String name){
        DepartmentEntity department = departmentService.getDepartmentByName(name);
        return new ArrayList<>(departmentService.getCurrentPatients(department));
     }
}
