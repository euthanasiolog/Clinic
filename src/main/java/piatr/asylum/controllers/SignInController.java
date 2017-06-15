package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.forms.SignIn;
import piatr.asylum.service.clinicService.department.DepartmentService;
import piatr.asylum.service.peopleService.UserService;
import piatr.asylum.service.peopleService.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class SignInController {
    @Autowired
    @Qualifier("doctorService")
    private
    UserService doctorService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    @Qualifier("nurseService")
    private
    UserService nurseService;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signInStart(ModelMap modelMap){
        SignIn signIn = new SignIn();
        modelMap.put("signIn", signIn);
        return "signInPage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(ModelMap modelMap, SignIn signIn){
        switch (signIn.getType()){
            case "DoctorEntity": {
                if(doctorService.isPasswordCorrect(signIn.getLogin(), signIn.getPassword(), signIn.getType())){
                    List<DepartmentEntity> departments = new ArrayList<>(departmentService.getAllDepartments());
                modelMap.addAttribute("departments", departments);
                    return "mainDoctorPage";
                }
                else {return "signInPage";}
            }
            case "NurseEntity": {
                if (nurseService.isPasswordCorrect(signIn.getLogin(),signIn.getPassword(),signIn.getType()))
                    return "mainNursePage";
                else return "signInPage";
            }
            default: return "signInPage";
        }
    }
}
