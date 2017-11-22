package piatr.asylum.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by piatr on 15.06.17.
 */
public class NewHospitalization {
    @NotBlank
    private String departmentName;

    private String startTime;

    @NotBlank
    private String id;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//    public String getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(String patientId) {
//        this.patientId = patientId;
//    }


}
