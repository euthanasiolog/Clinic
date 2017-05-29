package java.entity.peopleEntity.users;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.abstractClasses.ClinicEmployee;

/**
 * Created by piatr on 16.05.17.
 * пользователь доктор - он работает в каком-то отделении(может и не в одном, но использует в одну сессию только одно отделение)
 * доктору видна вся имеющаяся информация о пациенте (самый высокий уровень доступа)
 */
@Entity
@Table(name = "doctor")
public class DoctorEntity extends ClinicEmployee{
}
