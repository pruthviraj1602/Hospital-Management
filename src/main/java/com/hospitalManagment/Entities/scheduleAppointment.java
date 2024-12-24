package com.hospitalManagment.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class scheduleAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    private String appointmentScheduleDate;

    private String appointmentScheduleTime;

    @OneToOne
    @JoinColumn(name = "appointmentId",nullable = false)
    @JsonBackReference
    private Appointment appointment;

    private scheduleStatus scheduleStatus;

    //Setter And Getter


    public com.hospitalManagment.Entities.scheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(com.hospitalManagment.Entities.scheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getAppointmentScheduleDate() {
        return appointmentScheduleDate;
    }

    public void setAppointmentScheduleDate(String appointmentScheduleDate) {
        this.appointmentScheduleDate = appointmentScheduleDate;
    }

    public String getAppointmentScheduleTime() {
        return appointmentScheduleTime;
    }

    public void setAppointmentScheduleTime(String appointmentScheduleTime) {
        this.appointmentScheduleTime = appointmentScheduleTime;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}

