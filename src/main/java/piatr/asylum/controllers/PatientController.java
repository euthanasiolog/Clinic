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
import piatr.asylum.enumerations.Sex;
import piatr.asylum.forms.NewHospitalization;
import piatr.asylum.service.clinicService.department.DepartmentService;
import piatr.asylum.service.hospitalizationService.hospitalization.HospitalizationService;
import piatr.asylum.service.peopleService.patient.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.POST)
    public String newHospitalization(ModelMap modelMap, @Valid final NewHospitalization hospitalization, final BindingResult bindingResult){
        Long id = new Long(hospitalization.getId());
        PatientEntity patient = patientService.getPatientById(id);
        hospitalizationService.hospitalizationStart(patient, LocalDateTime.now(),
                departmentService.getDepartmentByName(hospitalization.getDepartmentName()));
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping(value = "patientPage", method = RequestMethod.GET)
    public String patientPage(HttpServletRequest request, ModelMap modelMap){
        String id = request.getParameter("id");
        PatientEntity patient = patientService.getPatientById(id);
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping(value = "/getAllPatients", method = RequestMethod.GET)
    public String getAllPatients(ModelMap modelMap){
        ArrayList<PatientEntity> allPatients = new ArrayList<>(patientService.getAllPatirnts());
        modelMap.addAttribute("allPatients", allPatients);
        return "allPatientsPage";
    }

    @RequestMapping(value = "redactPatient", method = RequestMethod.GET)
    public String redactPatient(HttpServletRequest request, ModelMap modelMap){
        String id = request.getParameter("id");
        PatientEntity patient = patientService.getPatientById(id);
        modelMap.addAttribute("patient", patient);
        return "redactPatientPage";
    }

    @RequestMapping(value = "redactPatient", method = RequestMethod.POST)
    public String redactedPatient(HttpServletRequest request, ModelMap modelMap){
        String id = request.getParameter("id");
        PatientEntity patient = patientService.getPatientById(id);
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String patronymic = request.getParameter("patronymic");
        String adress = request.getParameter("adress");
        String dateOfBirth = request.getParameter("dateOfBirth");
        if(firstName!=null){
            patient.setFirstName(firstName);
        }
        if (secondName!=null){
            patient.setSecondName(secondName);
        }
        if (patronymic!=null){
            patient.setPatronymic(patronymic);
        }
        if (adress!=null){
            patient.setAdress(adress);
        }
        if (request.getParameter("sex")!=null&&request.getParameter("sex").equals("MALE")){
            patient.setSex(Sex.MALE);
        }
        if (request.getParameter("sex")!=null&&request.getParameter("sex").equals("FEMALE")){
            patient.setSex(Sex.FEMALE);
        }
        if (dateOfBirth!=null){
            patient.setDateOfBirth(LocalDateTime.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd MM yyyy")));
        }
        patientService.update(patient);
        modelMap.addAttribute("patient", patient);
        return "redactPatientPage";
    }
}
