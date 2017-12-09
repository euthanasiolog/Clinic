package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.hospitalizationEntity.HospitalizationEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.enumerations.Sex;
import piatr.asylum.service.clinicService.departmentStamp.DepartmentStampService;
import piatr.asylum.service.hospitalizationService.hospitalization.HospitalizationService;
import piatr.asylum.service.peopleService.patient.PatientService;
import piatr.asylum.stamps.DepartmentStamp;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by piatr on 15.06.17.
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private HospitalizationService hospitalizationService;

    @Autowired
    private DepartmentStampService departmentStampService;

    @RequestMapping(value = "patientPage", method = RequestMethod.GET)
    public String patientPage(HttpServletRequest request, ModelMap modelMap){
        PatientEntity patient = patientService.getPatientById(request.getParameter("id"));
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
        if(firstName!=null&&!firstName.equals("")){
            patient.setFirstName(firstName);
        }
        if (secondName!=null&&!secondName.equals("")){
            patient.setSecondName(secondName);
        }
        if (patronymic!=null&&!patronymic.equals("")){
            patient.setPatronymic(patronymic);
        }
        if (adress!=null&&!adress.equals("")){
            patient.setAdress(adress);
        }
        if (request.getParameter("sex")!=null&&request.getParameter("sex").equals("MALE")){
            patient.setSex(Sex.MALE);
        }
        if (request.getParameter("sex")!=null&&request.getParameter("sex").equals("FEMALE")){
            patient.setSex(Sex.FEMALE);
        }
        if (dateOfBirth!=null&&!dateOfBirth.equals("")){
            patient.setDateOfBirth(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        patientService.update(patient);
        modelMap.addAttribute("patient", patient);
        return "redactPatientPage";
    }

    @RequestMapping(value ="/deletePatient", method = RequestMethod.GET)
    public String deletePatient(ModelMap modelMap, HttpServletRequest request){
        PatientEntity patient = patientService.getPatientById(request.getParameter("id"));
        for (HospitalizationEntity hosp:patient.getHospitalizations()){
            for (DepartmentStamp ds:hosp.getDepartmentStamps()){
                departmentStampService.delete(ds);
            }
            hospitalizationService.delete(hosp);
        }
        patientService.delete(patient);
        return getAllPatients(modelMap);
    }
}
