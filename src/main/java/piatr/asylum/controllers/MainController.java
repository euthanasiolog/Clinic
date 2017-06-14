package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.service.clinicService.department.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 03.06.17.
 */
@Controller
public class MainController {
    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/createPatient", method = RequestMethod.GET)
    public String createPatient(ModelMap modelMap){
        return "newPatient";
    }

    @RequestMapping(value = "/mainDoctorPage", method = RequestMethod.GET)
    public String allDepartments(ModelMap modelMap){
        List<DepartmentEntity> departments = new ArrayList<>(departmentService.getAllDepartments());
        modelMap.addAllAttributes(departments);
        return "mainDoctorPage";
    }

    @RequestMapping(value = "/setDepartmentDoctor", method = RequestMethod.POST)
    public String setDepartment(HttpServletRequest request, ModelMap modelMap){
        String department = request.getParameter("department");
        modelMap.addAllAttributes(departmentService.getCurrentPatients(departmentService.getDepartmentByName(department)));
        return "mainDoctorPage";
    }

}
