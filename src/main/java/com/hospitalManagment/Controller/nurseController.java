package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.Bill;
import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.scheduleAppointment;
import com.hospitalManagment.Entities.updateAppointmentResponse;
import com.hospitalManagment.Services.IMPL.appointmentServiceIMPL;
import com.hospitalManagment.Services.IMPL.billServiceIMPL;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/nurse")
public class nurseController {

    @Autowired
    private userServiceIMPL userServiceIMPL;

    @Autowired
    private appointmentServiceIMPL appointmentServiceIMPL;

    @Autowired
    private billServiceIMPL billServiceIMPL;

    @PostMapping("/save-nurse")
    public ResponseEntity<Doctor> saveUser(@RequestBody Doctor doctor){
        doctor.setRole("NURSE");
        Doctor doctor1 = userServiceIMPL.saveDoctor(doctor);

        if(doctor1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(doctor1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/scheduleAppointment")
    public ResponseEntity<scheduleAppointment> scheduleAppointment(@RequestBody scheduleAppointment scheduleAppointment){
        scheduleAppointment scheduleAppointment1 = appointmentServiceIMPL.scheduleAppointment(scheduleAppointment);
        if(scheduleAppointment1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(scheduleAppointment1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<?> updateStatus(@RequestBody updateAppointmentResponse appointmentResponse){
        int appointment = appointmentServiceIMPL.updateAppointmentStatus(appointmentResponse);

        if(appointment!=0){
            return ResponseEntity.status(HttpStatus.OK).body("Patient Status Updated:-> "+appointmentResponse.getStatus());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient Status Not Updated ");
    }

    @PostMapping("/payment")
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill){
        Bill bill1 = billServiceIMPL.saveBill(bill);
        if(bill1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(bill1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
