package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.forms.NewHospitalization;
import piatr.asylum.service.peopleService.patient.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by piatr on 15.06.17.
 */
@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.GET)
    public String newHosp(ModelMap modelMap, HttpServletRequest request){
        String id = request.getParameter("id");
        NewHospitalization hospitalization = new NewHospitalization();
        modelMap.addAttribute("newHospitalization", hospitalization);
        modelMap.addAttribute("id", id);
        return "newHospitalization";
    }

    @RequestMapping(value = "patientPage", method = RequestMethod.POST)
    public String getPatientPage(HttpServletRequest request, ModelMap modelMap){
        String idS = request.getParameter("id");
        Long id = new Long(idS);
        PatientEntity patient = patientService.getPatientById(id);
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.POST)
    public String newHospitalization(ModelMap modelMap, @Valid final NewHospitalization hospitalization, final BindingResult bindingResult){

        return "newHospitalization";
    }
}
