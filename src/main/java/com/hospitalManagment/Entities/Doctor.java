package com.hospitalManagment.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-doctor")
    private User user;

    private String doctorName;
    private String doctorContact;
    private String doctorAddress;

    private String specialization;

    private int experience;

    private String availability;




    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference("doctor-appointments")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonManagedReference("doctor-medicalRecord")
    private List<medicalRecord> medicalRecords;


    //setter Getter


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public List<medicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<medicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }



    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
