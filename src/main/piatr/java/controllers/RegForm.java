package java.controllers;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by piatr on 29.05.17.
 */

public class RegForm {

    @NotBlank
    @Length(min = 2, max = 20)
    private String login;

    @NotBlank
    @Length(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Length(min = 2, max = 20)
    private String secondName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 4)
    private String password;

    @NotBlank
    @Length(min = 4)
    private String confirmPassword;

    public RegForm() {
        this.login = "";
        this.firstName = "";
        this.secondName = "";
        this.email = "";
        this.password = "";
        this.confirmPassword = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}