package com.hospitalManagment.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

//import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    private String appointmentDate;

    private String appointmentTime;

    private String healthIssue;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference("patient-appointments")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference("doctor-appointments")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL)
    @JsonManagedReference
    private scheduleAppointment scheduleAppointment;

    @OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Bill bill;


    //Getter And Setter

    public com.hospitalManagment.Entities.scheduleAppointment getScheduleAppointment() {
        return scheduleAppointment;
    }

    public void setScheduleAppointment(com.hospitalManagment.Entities.scheduleAppointment scheduleAppointment) {
        this.scheduleAppointment = scheduleAppointment;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
