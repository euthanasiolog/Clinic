package java.abstractClasses;

import javax.persistence.*;
import java.abstractClasses.BaseEntity;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by piatr on 18.05.17.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Human extends BaseEntity implements Serializable{
    @Column
    @Id
    @GeneratedValue
    long id;
    @Column
    String firstName;
    @Column
    String secondName;
    @Column
    String patronymic;
    @Column
    LocalDateTime dateOfBirth;
}
