package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appointmentRepository extends JpaRepository<Appointment,Integer> {
}
