package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient,Integer> {

    public Patient getPatientByPatientId(Integer patientId);

    @Transactional
    public Integer deletePatientByPatientId(Integer patientId);
}
