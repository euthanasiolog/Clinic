package piatr.asylum.forms;

import org.hibernate.validator.constraints.NotBlank;
import piatr.asylum.enumerations.Sex;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by piatr on 03.06.17.
 */
public class NewPatient {
    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    private String patronymic;

    private String dateOfBirth;

    @NotBlank
    private String adress;

    public NewPatient() {
        this.firstName = "";
        this.secondName = "";
        this.patronymic = "";
        this.adress = "";
        this.dateOfBirth ="";
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
