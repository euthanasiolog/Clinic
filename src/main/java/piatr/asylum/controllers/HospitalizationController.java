package piatr.asylum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by piatr on 07.12.17.
 */
@Controller
public class HospitalizationController {
    @Autowired
    PatientService patientService;

    @Autowired
    HospitalizationService hospitalizationService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.GET)
    public String newHosp(ModelMap modelMap, @RequestParam("id") String id){
        NewHospitalization hospitalization = new NewHospitalization();
        modelMap.addAttribute("newHospitalization", hospitalization);
        modelMap.addAttribute("id", id);
        List<DepartmentEntity> departments = departmentService.getAllDepartments();
        modelMap.addAttribute("departments", departments);
        return "newHospitalization";
    }

    @RequestMapping(value = "/newHospitalization", method = RequestMethod.POST)
    public String newHospitalization(ModelMap modelMap, @Valid final NewHospitalization hospitalization,
                                     final BindingResult bindingResult){
        Long id = new Long(hospitalization.getId());
        PatientEntity patient = patientService.getPatientById(id);
        hospitalizationService.hospitalizationStart(patient, LocalDateTime.now(),
                departmentService.getDepartmentByName(hospitalization.getDepartmentName()));
        modelMap.addAttribute("patient", patient);
        return "patientPage";
    }

    @RequestMapping (value = "/endHospitalization", method = RequestMethod.GET)
    public String endHospitalization(ModelMap modelMap, @RequestParam("hospitalizationId") int id){
        HospitalizationEntity hospitalization = hospitalizationService.getHospitalizationById(id);
        modelMap.addAttribute("hospitalization", hospitalization);
        return "endHospitalizationPage";
    }

    @RequestMapping (value = "/endHospitalization", method = RequestMethod.POST)
    public String endHosp(ModelMap modelMap,@RequestParam("hospitalizationId") int id,
                          @RequestParam("time") String date){
        HospitalizationEntity hospitalization = hospitalizationService.getHospitalizationById(id);
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        hospitalizationService.hospitalizationEnd(hospitalization, dateTime);
        modelMap.addAttribute("hospitalization", hospitalization);
        return "redactHospitalizationPage";
    }

    @RequestMapping(value = "/redactHospitalization", method = RequestMethod.GET)
    public String redactHospitalization(ModelMap modelMap, @RequestParam("hospitalizationId") int id){
        HospitalizationEntity hospitalization = hospitalizationService.getHospitalizationById(id);
        modelMap.addAttribute("hospitalization", hospitalization);
        return "redactHospitalizationPage";
    }

    @RequestMapping(value = "/changeDepartment", method = RequestMethod.GET)
    public String changeDepartment(ModelMap modelMap,  @RequestParam("hospitalizationId") int id){
        HospitalizationEntity hospitalization = hospitalizationService.getHospitalizationById(id);
        PatientEntity patient = hospitalization.getPatient();
        List<DepartmentEntity> departments = new ArrayList<>(departmentService.getAllDepartments());
        modelMap.addAttribute("departments", departments);
        modelMap.addAttribute("hospitalization", hospitalization);
        modelMap.addAttribute("departments", departmentService.getAllDepartments());
        return "changeDepartmentPage";
    }

    @RequestMapping(value = "/changeDepartment", method = RequestMethod.POST)
    public String changeDep(ModelMap modelMap, @RequestParam("hospitalizationId") int id,
                            @RequestParam("time") String date, @RequestParam("department") String dep){
        HospitalizationEntity hospitalization = hospitalizationService.getHospitalizationById(id);
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
        DepartmentEntity department = departmentService.getDepartmentByName(dep);
        hospitalizationService.changeDepartment(hospitalization, dateTime, department);
        PatientEntity patient = hospitalization.getPatient();
        modelMap.addAttribute("patient", patient);
        modelMap.addAttribute("departments", departmentService.getAllDepartments());
        modelMap.addAttribute("hospitalization", hospitalization);
        return "redactHospitalizationPage";
    }

}
