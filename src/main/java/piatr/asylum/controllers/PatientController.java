package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.forms.NewHospitalization;
import piatr.asylum.service.clinicService.department.DepartmentService;
import piatr.asylum.service.hospitalizationService.hospitalization.HospitalizationService;
import piatr.asylum.service.peopleService.patient.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 15.06.17.
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private HospitalizationService hospitalizationService;


    @RequestMapping(value = "/newHospitalization", method = RequestMethod.GET)
    public String newHosp(ModelMap modelMap, HttpServletRequest request){
        String id = request.getParameter("id");
        NewHospitalization hospitalization = new NewHospitalization();
        modelMap.addAttribute("newHospitalization", hospitalization);
        modelMap.addAttribute("id", id);
        List<DepartmentEntity> departments = departmentService.getAllDepartments();
        modelMap.addAttribute("departments", departments);
        return "newHospitalization";
    }

    @RequestMapping(value = "patientPage", method = RequestMethod.GET)
    public String patientPage(HttpServletRequest request, ModelMap modelMap){
        String pid = request.getParameter("id");
        Long id = new Long(pid);
        PatientEntity patient = patientService.getPatientById(id);
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.POST)
    public String newHospitalization(ModelMap modelMap, @Valid final NewHospitalization hospitalization, final BindingResult bindingResult){
        Long id = new Long(hospitalization.getId());
        PatientEntity patient = patientService.getPatientById(id);
        hospitalizationService.hospitalizationStart(patient, LocalDateTime.now(),
                departmentService.getDepartmentByName(hospitalization.getDepartmentName()));
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping(value = "/getAllPatients", method = RequestMethod.GET)
    public String getAllPatients(ModelMap modelMap){
        ArrayList<PatientEntity> allPatients = new ArrayList<>(patientService.getAllPatirnts());
        modelMap.addAttribute("allPatients", allPatients);
        return "allPatientsPage";
    }
}
