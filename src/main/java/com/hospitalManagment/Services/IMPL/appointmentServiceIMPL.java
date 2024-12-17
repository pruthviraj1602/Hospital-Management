package com.hospitalManagment.Services.IMPL;

import ch.qos.logback.core.util.Loader;
import com.hospitalManagment.Entities.Appointment;
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

        return appointmentRepository.save(appointment);
    }
}
