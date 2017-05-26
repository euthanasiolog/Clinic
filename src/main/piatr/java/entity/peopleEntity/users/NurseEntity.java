package java.entity.peopleEntity.users;

import abstractClasses.ClinicEmployee;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.abstractClasses.ClinicEmployee;
import java.io.Serializable;

/**
 * Created by piatr on 16.05.17.
 * пользователь медсестра
 * как и доктор, работает в одном или (тоже млжет быть) в нескольких отделениях
 * медсестре не видна вся информация, в принципе ей нужна другая инфа в другом виде:
 * это назначенные лекарства, анализы, специалисты, некоторые данные пациента(аллергия или побочные реакции на препараты и т.п.)
 * медсестра их менять сама не может(может, например, делать примечания, но не менять)
 * и ей видны только пациенты, лежащие в данный момент лежат в отделени
 */
@Entity
@Table(name = "nurse")
public class NurseEntity extends ClinicEmployee {
}
