package piatr.asylum.entity.hospitalizationEntity;

import javax.persistence.*;

import piatr.asylum.abstractClasses.BaseEntity;

import java.time.LocalDateTime;

/**
 * Created by piatr on 21.05.17.
 */
@Entity
@Table(name = "consultation")
public class ConsultationEntity extends BaseEntity {

    //какой специалист консультировал
    @Column
    String doctorType;

    //дата назначения консультации
    @Column
    LocalDateTime appointConsultationTime;

    //дата консультации
    @Column
    LocalDateTime consultationTime;

    //собственно, текст самой консультации, осмотра, и т.п.
    @Column
    String consultation;

    //диагноз, который поставил специалист, или заключение
    @Column
    String diagnosis;

    //рекомендации по лечению и т.п.
    @Column
    String recomendation;


    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public LocalDateTime getAppointConsultationTime() {
        return appointConsultationTime;
    }

    public void setAppointConsultationTime(LocalDateTime appointConsultationTime) {
        this.appointConsultationTime = appointConsultationTime;
    }

    public LocalDateTime getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(LocalDateTime consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }
}
