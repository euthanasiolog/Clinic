package piatr.asylum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by piatr on 14.06.17.
 */
@Controller
public class ClinicController {

    @RequestMapping(value = "/newClinic", method = RequestMethod.GET)
    public String newClinicPage(HttpServletRequest request, ModelMap modelMap){

        return "NewClinicPage";
    }

    @RequestMapping(value = "/newClinic", method = RequestMethod.POST)
    public String newClinic(HttpServletRequest request, ModelMap modelMap){

        return "clinicPage";
    }

    @RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
    public String newDepartmentPage(ModelMap modelMap){
        return "NewDepartmentPage";
    }

    @RequestMapping(value = "/newDepartment", method = RequestMethod.POST)
    public String newDepartment(ModelMap modelMap){
        return "clinicPage";
    }
}
