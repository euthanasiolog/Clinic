package piatr.asylum.forms;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

/**
 * Created by piatr on 03.06.17.
 */
public class NewPatient {
    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    private String lastName;


}
