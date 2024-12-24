package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.*;
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
        scheduleAppointment.setScheduleStatus(scheduleStatus.PENDING);
        scheduleAppointment scheduleAppointment1 = appointmentServiceIMPL.scheduleAppointment(scheduleAppointment);
        if(scheduleAppointment1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(scheduleAppointment1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/update-scheduleAppointment")
    public ResponseEntity<scheduleAppointment> updateScheduleAppointment(@RequestBody scheduleAppointment scheduleAppointment){
      scheduleAppointment scheduleAppointment1 = appointmentServiceIMPL.scheduleAppointment(scheduleAppointment);
      if(scheduleAppointment1!=null){
          return ResponseEntity.status(HttpStatus.OK).body(scheduleAppointment);
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }



    @PutMapping("/updateStatus/{scheduleId}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer scheduleId){
        int i = appointmentServiceIMPL.updateScheduleAppointmentStatus(scheduleId);
        if(i!=0){
            return ResponseEntity.status(HttpStatus.OK).body("schedule Appointment Update as COMPLETE at Id: "+scheduleId);
        }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Schedule Appointment Not Update");
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
