package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.Appointment;
import com.hospitalManagment.Entities.Patient;
import com.hospitalManagment.Services.IMPL.appointmentServiceIMPL;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
public class patientController {

    @Autowired
    private userServiceIMPL userServiceIMPL;

    @Autowired
    private appointmentServiceIMPL appointmentServiceIMPL;

    @PostMapping("/add-patient")
    public ResponseEntity<Patient> saveUser(@RequestBody Patient patient){

        Patient patient1 = userServiceIMPL.savePatient(patient);

        if(patient1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(patient1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/getAppointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){

        Appointment appointment1 = appointmentServiceIMPL.saveAppointment(appointment);
        if(appointment1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getPatient/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Integer patientId){
        Patient patient = userServiceIMPL.getPatient(patientId);
        if(patient!=null){
            return ResponseEntity.status(HttpStatus.OK).body(patient);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
