package com.hospitalManagment.Services;

import com.hospitalManagment.Entities.Appointment;
import com.hospitalManagment.Entities.scheduleAppointment;
import com.hospitalManagment.Entities.updateAppointmentResponse;

public interface appointmentService {

    public Appointment saveAppointment(Appointment appointment);

    public int updateAppointmentStatus(updateAppointmentResponse appointmentResponse);

    public scheduleAppointment scheduleAppointment(scheduleAppointment scheduleAppointment);

}
