package piatr.asylum.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by piatr on 14.06.17.
 */
public class NewDepartment {
    public NewDepartment() {
        this.name = "";
        this.volume = 0;
        this.sex = "";
    }

    @NotBlank
    private String name;
    
    private int volume;

    @NotBlank
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}