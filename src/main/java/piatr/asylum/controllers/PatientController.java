package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.forms.NewHospitalization;
import piatr.asylum.service.peopleService.patient.PatientService;

import javax.validation.Valid;

/**
 * Created by piatr on 15.06.17.
 */
@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.GET)
    public String newHosp(ModelMap modelMap){
        NewHospitalization hospitalization = new NewHospitalization();
        modelMap.addAttribute("newHospitalization", hospitalization);
        return "newHospitalization";
    }

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.POST)
    public String newHospitalization(ModelMap modelMap, @Valid final NewHospitalization hospitalization, final BindingResult bindingResult){

        return "newHospitalization";
    }
}
