package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.service.clinicService.department.DepartmentService;

import java.util.ArrayList;

/**
 * Created by piatr on 21.11.17.
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String getDepartments (ModelMap modelMap){
        ArrayList<DepartmentEntity> departments =
                new ArrayList<>(departmentService.getAllDepartments());
        modelMap.addAttribute("departments", departments);
        return "departmentsPage";
    }

    @RequestMapping (value = "deleteDepartment", method = RequestMethod.GET)
    public String deleteDepartment (ModelMap modelMap, String departmentName){
        DepartmentEntity department = departmentService.getDepartmentByName(departmentName);
        departmentService.delete(department);
        return "departmentsPage";
    }

}
