package piatr.asylum.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by piatr on 15.06.17.
 */
public class NewHospitalization {
    @NotBlank
    private String departmentName;

    private String startTime;



}
