package piatr.asylum.controllers;

import javafx.util.converter.LocalDateTimeStringConverter;
import org.apache.commons.beanutils.locale.converters.BigIntegerLocaleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import piatr.asylum.entity.clinicEntity.DepartmentEntity;
import piatr.asylum.entity.peopleEntity.PatientEntity;
import piatr.asylum.forms.NewPatient;
import piatr.asylum.service.clinicService.department.DepartmentService;
import piatr.asylum.service.peopleService.patient.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

/**
 * Created by piatr on 03.06.17.
 */
@Controller
public class MainController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PatientService patientService;


    @RequestMapping(value = "/createPatient", method = RequestMethod.GET)
    public String createPatient(ModelMap modelMap){
        NewPatient patient = new NewPatient();
        modelMap.addAttribute("newPatient", patient);
        return "newPatient";
    }

    @RequestMapping(value = "/createPatient", method = RequestMethod.POST)
    public String newPatient(ModelMap modelMap,@Valid final NewPatient newPatient,final BindingResult bindingResult) {
        if (bindingResult.hasErrors())return "newPatient";
        else {
            PatientEntity patientEntity = new PatientEntity();
            patientEntity.setFirstName(newPatient.getFirstName());
            patientEntity.setSecondName(newPatient.getSecondName());
            patientEntity.setPatronymic(newPatient.getPatronymic());
            patientEntity.setDateOfBirth(LocalDate.parse(newPatient.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            patientService.create(patientEntity);
            modelMap.addAttribute("patient", patientEntity);
            return "patientPage";
        }
    }

    @RequestMapping(value = "/mainDoctorPage", method = RequestMethod.GET)
    public String allDepartments(ModelMap modelMap){
        List<DepartmentEntity> departments = new ArrayList<>(departmentService.getAllDepartments());
        modelMap.addAttribute("departments", departments);
        return "mainDoctorPage";
    }

    @RequestMapping(value = "/setDepartmentDoctor", method = RequestMethod.POST)
    public String setDepartment(HttpServletRequest request, ModelMap modelMap){
        String department = request.getParameter("department");
        DepartmentEntity departmentEntity = departmentService.getDepartmentByName(department);
        List<PatientEntity> patients = new ArrayList<>(departmentService.getCurrentPatients(departmentEntity));
        modelMap.addAttribute("patients", patients);
        List<DepartmentEntity> departments = new ArrayList<>(departmentService.getAllDepartments());
        modelMap.addAttribute("departments", departments);
        return "mainDoctorPage";
    }
}
