package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<Doctor,Integer> {

    public Doctor getDoctorByDoctorId(Integer doctorId);

    public Integer deleteDoctorByDoctorId(Integer doctorId);
}
