package java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.entity.peopleEntity.users.DoctorEntity;
import java.forms.RegForm;
import java.service.peopleService.doctor.impl.DoctorServiceImpl;

/**
 * Created by piatr on 23.05.17.
 */
@Controller
public class RegistrationController {
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg(ModelMap modelMap){
        RegForm regForm = new RegForm();
        modelMap.put("regForm", regForm);
        return "regPage";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registration(@Valid final RegForm regForm, ModelMap modelMap, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "regPage";
        else if (regForm.getPassword().equals(regForm.getConfirmPassword())) {
            modelMap.addAttribute("name", regForm.getFirstName());
            DoctorServiceImpl doctorService = new DoctorServiceImpl();
            doctorService.create(new DoctorEntity(regForm.getFirstName(), regForm.getSecondName(), regForm.getLogin(), regForm.getPassword()));
            return "regOk";
        }
        return "regPage";
    }
    @RequestMapping(value = "/regOk")
    public String regOk(){
        return "mainPage";
    }
}