package com.hospitalManagment.Services.IMPL;

import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.Patient;
import com.hospitalManagment.Repositories.doctorRepository;
import com.hospitalManagment.Repositories.patientRepository;
import com.hospitalManagment.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceIMPL implements userService {



    @Autowired
    private patientRepository patientRepository;

    @Autowired
    private doctorRepository doctorRepository;



    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }




    @Override
    public List<Patient> getAllUser() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Integer patientId) {
        return patientRepository.getPatientByPatientId(patientId);
    }

    @Override
    public Integer deletePatient(Integer patientId) {
        return patientRepository.deletePatientByPatientId(patientId);
    }



    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(Integer doctorId) {
        return doctorRepository.getDoctorByDoctorId(doctorId);
    }

    @Override
    public Integer deleteDoctor(Integer doctorId) {
        return doctorRepository.deleteDoctorByDoctorId(doctorId);
    }
}
