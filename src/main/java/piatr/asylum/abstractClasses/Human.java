package piatr.asylum.abstractClasses;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by piatr on 18.05.17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Human extends BaseEntity implements Serializable{
    @Column
    public String firstName;
    @Column
    public String secondName;
    @Column
    public String patronymic;
    @Column
    public LocalDateTime dateOfBirth;

}
