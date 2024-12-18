package com.hospitalManagment.Services.IMPL;

import ch.qos.logback.core.util.Loader;
import com.hospitalManagment.Entities.Appointment;
import com.hospitalManagment.Entities.AppointmentStatus;
import com.hospitalManagment.Entities.updateAppointmentResponse;
import com.hospitalManagment.Repositories.appointmentRepository;
import com.hospitalManagment.Services.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class appointmentServiceIMPL implements appointmentService {

    @Autowired
    private appointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
       appointment.setAppointmentDate(LocalDate.now().toString());
       appointment.setAppointmentTime(LocalTime.now().toString());
       appointment.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appointment);
    }

    @Override
    public int updateAppointmentStatus(updateAppointmentResponse appointmentResponse) {

        Integer appointmentId = appointmentResponse.getAppointmentId();
        AppointmentStatus status = appointmentResponse.getStatus();
        int appointment = appointmentRepository.updateAppointmentStatus(appointmentId, status);
        if(appointment==0){
            throw new RuntimeException("No appointment found with id " + appointmentId);
        }
        return appointment;
    }
}
