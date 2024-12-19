package com.hospitalManagment.Services;

import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.Patient;

import java.util.List;
import java.util.Optional;

public interface userService {





    //Patient
    public Patient savePatient(Patient patient);

    public List<Patient> getAllUser();

    public Patient getPatient(Integer patientId);

    public Integer deletePatient(Integer patientId);


    //Doctor
    public Doctor saveDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    public Doctor getDoctor(Integer doctorId);

    public Integer deleteDoctor(Integer doctorId);

}
