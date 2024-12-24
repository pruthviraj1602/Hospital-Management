package com.hospitalManagment.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-patient")
    private User user;

    private String patientName;
    private String patientContact;
    private String dateOfBirth;
    private String patientAddress;




    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonManagedReference("patient-appointments")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    @JsonManagedReference("patient-medicalRecord")
    private List<medicalRecord> medicalRecords;


    //setter Getter


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public List<medicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<medicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirth = dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }



    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
