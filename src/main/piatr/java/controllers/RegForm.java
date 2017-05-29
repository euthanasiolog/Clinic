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
    private String name;

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
        this.name = "";
        this.email = "";
        this.password = "";
        this.confirmPassword = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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