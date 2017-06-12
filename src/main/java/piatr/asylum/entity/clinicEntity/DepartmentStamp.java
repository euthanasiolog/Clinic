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
    private LocalDateTime from;

    @Column
    private LocalDateTime to;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
