package com.hospitalManagment.Entities;

import lombok.Data;

@Data
public class updateAppointmentResponse {

    private Integer appointmentId;
    private AppointmentStatus status;

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
