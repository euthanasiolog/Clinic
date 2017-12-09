package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.enumerations.Sex;
import piatr.asylum.forms.NewDepartment;
import piatr.asylum.service.clinicService.department.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;

/**
 * Created by piatr on 14.06.17.
 */
@Controller
public class ClinicController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
    public String newDepartmentPage(ModelMap modelMap){
        NewDepartment department = new NewDepartment();
        modelMap.addAttribute("newDepartment", department);
        return "newDepartmentPage";
    }

    @RequestMapping(value = "/newDepartment", method = RequestMethod.POST)
    public String newDepartment(ModelMap modelMap, @Valid final NewDepartment newDepartment,final BindingResult bindingResult) {
        if ((bindingResult.hasErrors())||(departmentService.getDepartmentByName(newDepartment.getName())!=null))
        {return "newDepartmentPage";}
        else {
            DepartmentEntity department = new DepartmentEntity();
            department.setName(newDepartment.getName());
            department.setVolumeOfDepartment(newDepartment.getVolume());
            if(newDepartment.getSex().equals("male")){department.setSex(Sex.MALE);}else {
            if (newDepartment.getSex().equals("female"))department.setSex(Sex.FEMALE);}
            departmentService.create(department);
            return "clinicPage";
        }
    }
}
