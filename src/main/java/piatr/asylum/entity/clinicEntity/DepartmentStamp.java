package piatr.asylum.entity.clinicEntity;

import piatr.asylum.abstractClasses.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by piatr on 12.06.17.
 */
@Entity
public class DepartmentStamp extends BaseEntity
{
    @Column
    private String departmentName;

    @Column
    private LocalDateTime fromTime;

    @Column
    private LocalDateTime toTime;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime from) {
        this.fromTime = from;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }
}
