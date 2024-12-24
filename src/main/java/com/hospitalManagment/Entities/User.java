package com.hospitalManagment.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;



    @Column(nullable = false)
    private String role; // ADMIN, DOCTOR, PATIENT



    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("user-patient")
    private Patient patient;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference("user-doctor")
    private Doctor doctor;


    //Setter And Getter

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
