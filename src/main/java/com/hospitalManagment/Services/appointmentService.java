package com.hospitalManagment.Services;

import com.hospitalManagment.Entities.Appointment;
import com.hospitalManagment.Entities.scheduleAppointment;
import com.hospitalManagment.Entities.updateAppointmentResponse;

import java.util.List;

public interface appointmentService {

    public Appointment saveAppointment(Appointment appointment);



    public List<Appointment> getAppointments();

    public List<Appointment> getAppointment(Integer doctorId);


    //schedule Appointments

    public scheduleAppointment scheduleAppointment(scheduleAppointment scheduleAppointment);
    public List<scheduleAppointment> getScheduleAppointment();

    public int updateScheduleAppointmentStatus(Integer scheduleId);

}
