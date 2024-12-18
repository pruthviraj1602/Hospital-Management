package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Appointment;
import com.hospitalManagment.Entities.AppointmentStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface appointmentRepository extends JpaRepository<Appointment,Integer> {

//    public Appointment updateAppointmentStatus(Integer appointmentId, AppointmentStatus status);
     @Modifying
     @Transactional
     @Query("UPDATE Appointment a SET a.status = :status WHERE a.id = :appointmentId")
     public int updateAppointmentStatus(@Param("appointmentId") Integer appointmentId, @Param("status") AppointmentStatus status);
}
