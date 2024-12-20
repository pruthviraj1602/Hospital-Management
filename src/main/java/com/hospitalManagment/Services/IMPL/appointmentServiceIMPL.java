package com.hospitalManagment.Services.IMPL;

import ch.qos.logback.core.util.Loader;
import com.hospitalManagment.Entities.*;
import com.hospitalManagment.Repositories.appointmentRepository;
import com.hospitalManagment.Repositories.patientRepository;
import com.hospitalManagment.Repositories.scheduleAppointmentRepository;
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

    @Autowired
    private scheduleAppointmentRepository scheduleRepository;

    @Autowired
    private patientRepository patientRepository;


    @Autowired
    private emailServiceIMPL emailServiceIMPL;

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


    @Override
    public scheduleAppointment scheduleAppointment(scheduleAppointment scheduleAppointment) {
        Integer appointmentId = scheduleAppointment.getAppointment().getAppointmentId();
        Appointment appointment = appointmentRepository.getAppointmentByAppointmentId(appointmentId);
        //Gey Patient from Appointment table
        Integer patientId = appointment.getPatient().getPatientId();
        Patient patient = patientRepository.getPatientByPatientId(patientId);

//        getting mail from patient table
        String patientEmail = patient.getPatientEmail();

//        System.out.println(patientEmail);

        String message="Your Appointment Schedule at: "+scheduleAppointment.getAppointmentScheduleDate()+" & Time: "+scheduleAppointment.getAppointmentScheduleTime();
        String subject="Appointment Schedule";
        emailServiceIMPL.sendEmail(patientEmail,message,subject);
        return scheduleRepository.save(scheduleAppointment);
    }
}
