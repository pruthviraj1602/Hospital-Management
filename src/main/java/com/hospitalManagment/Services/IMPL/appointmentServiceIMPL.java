package com.hospitalManagment.Services.IMPL;

import com.hospitalManagment.Entities.*;
import com.hospitalManagment.Repositories.appointmentRepository;
import com.hospitalManagment.Repositories.patientRepository;
import com.hospitalManagment.Repositories.scheduleAppointmentRepository;
import com.hospitalManagment.Repositories.userRepository;
import com.hospitalManagment.Services.appointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private userRepository userRepository;


    @Override
    public Appointment saveAppointment(Appointment appointment) {
       appointment.setAppointmentDate(LocalDate.now().toString());
       appointment.setAppointmentTime(LocalTime.now().toString());
       appointment.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appointment);
    }

    @Override
    public scheduleAppointment scheduleAppointment(scheduleAppointment scheduleAppointment) {
        Integer appointmentId = scheduleAppointment.getAppointment().getAppointmentId();
        Appointment appointment = appointmentRepository.getAppointmentByAppointmentId(appointmentId);
        //Get Patient from Appointment table
        Integer patientId = appointment.getPatient().getPatientId();
        System.out.println(patientId);
        Patient patient = patientRepository.getPatientByPatientId(patientId);

        Integer userId = patient.getUser().getUserId();
        System.out.println(userId);
        User userById = userRepository.getUserByUserId(userId);

        String userEmail = userById.getUserEmail();
        System.out.println(userEmail);

        String message="Your Appointment Schedule at: "+scheduleAppointment.getAppointmentScheduleDate()+" & Time: "+scheduleAppointment.getAppointmentScheduleTime();
        String subject="Appointment Schedule";
        emailServiceIMPL.sendEmail(userEmail,message,subject);

        //When Mail is Send then Appointment schedule is stored in the appointment table where it converts pending -> schedule
        //we get schedule throw AppointmentStatus entity
        AppointmentStatus status = AppointmentStatus.SCHEDULE;

        //get id from the above and status
        appointmentRepository.updateAppointmentStatus(appointmentId, status);

        return scheduleRepository.save(scheduleAppointment);
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointment(Integer doctorId) {
        return appointmentRepository.getAppointmentsByDoctorId(doctorId);
    }

    @Override
    public List<scheduleAppointment> getScheduleAppointment() {
        return scheduleRepository.findAll();
    }

    @Override
    public int updateScheduleAppointmentStatus(Integer scheduleId) {

        scheduleStatus complete = scheduleStatus.COMPLETE;
        int i = scheduleRepository.updateScheduleAppointmentStatusByScheduleId(scheduleId, complete);
        System.out.println(i);
        if(i==0){
            throw new RuntimeException("Appointment Not Found: "+scheduleId);
        }

        return i;
    }
}
