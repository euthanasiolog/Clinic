package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import piatr.asylum.entity.peopleEntity.users.DoctorEntity;
import piatr.asylum.service.peopleService.doctor.DoctorService;
import piatr.asylum.service.peopleService.doctor.impl.DoctorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import piatr.asylum.forms.RegForm;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class RegistrationController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg(ModelMap modelMap){
        RegForm regForm = new RegForm();
        regForm.setEmail("dsdeee");
        modelMap.put("regForm", regForm);
        return "regPage";
    }


    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registration(ModelMap modelMap,@Valid final RegForm regForm,  final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "regPage";
        else if (regForm.getPassword().equals(regForm.getConfirmPassword())) {
            modelMap.addAttribute("name", regForm.getFirstName());
            //DoctorEntity doctorEntity = new DoctorEntity(regForm.getFirstName(), regForm.getSecondName(), regForm.getLogin(), regForm.getPassword(), regForm.getEmail());
            doctorService.create(new DoctorEntity(regForm.getFirstName(), regForm.getSecondName(), regForm.getLogin(), regForm.getPassword(), regForm.getEmail()));
            return "regOk";
        }
        return "regPage";
    }
    @RequestMapping(value = "/regOk")
    public String regOk(){
        return "mainPage";
    }
}