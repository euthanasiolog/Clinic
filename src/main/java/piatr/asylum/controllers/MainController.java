package piatr.asylum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.peopleEntity.PatientEntity;

/**
 * Created by piatr on 03.06.17.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/createPatient", method = RequestMethod.GET)
    public String createPatient(ModelMap modelMap){

        return "newPatient";
    }
}
