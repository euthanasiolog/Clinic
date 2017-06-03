package piatr.asylum.entity.clinicEntity;


import piatr.asylum.abstractClasses.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by piatr on 16.05.17.
 * список отделений. в больнице их много
 * в каждом отделении работает несколько врачей
 * в принципе, и один и тот же врач может работать в нескольких отделениях
 * в каждом отделении есть пациенты, которые лежат в нем, или лежали
 * мы в приложении работаем в основном с лежащими на данный момент в отделении(выбираем из всего списка, у кого госпитализация
 * активна, и отеделение соответсвует тому, с которым работаем)
 * вопрос - надо ли делать для этого отдельные таблицы или использовать джава-коллекции(arrayList, напр.) для каждой сессии?
 * в среднем в отделении лежит 40-60 человек
 */
@Entity
@Table(name = "department")
public class ClinicDepartmentEntity extends BaseEntity {
    @Column
    String name;

    @Column
    int volumeOfDepartment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolumeOfDepartment() {
        return volumeOfDepartment;
    }

    public void setVolumeOfDepartment(int volumeOfDepartment) {
        this.volumeOfDepartment = volumeOfDepartment;
    }



}
