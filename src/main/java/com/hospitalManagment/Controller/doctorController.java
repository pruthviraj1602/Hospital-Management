package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.*;
import com.hospitalManagment.Services.IMPL.appointmentServiceIMPL;
import com.hospitalManagment.Services.IMPL.medicalRecordServiceIMPL;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
public class doctorController {


    @Autowired
    private userServiceIMPL userServiceIMPL;

    @Autowired
    private appointmentServiceIMPL appointmentServiceIMPL;

    @Autowired
    private medicalRecordServiceIMPL medicalRecordServiceIMPL;


    @PostMapping("/add-doctor")
    public ResponseEntity<Doctor> saveUser(@RequestBody Doctor doctor){

        Doctor doctor1 = userServiceIMPL.saveDoctor(doctor);

        if(doctor1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(doctor1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getDoctor/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Integer doctorId){
        Doctor doctor = userServiceIMPL.getDoctor(doctorId);
        if(doctor!=null){
            return ResponseEntity.status(HttpStatus.OK).body(doctor);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    



    //Medical Records

    @PostMapping("/add-patientRecord")
    public ResponseEntity<medicalRecord> saveRecord(@RequestBody medicalRecord record){
        medicalRecord medicalRecord = medicalRecordServiceIMPL.saveRecords(record);
        if(medicalRecord!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecord);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getDoctor-Appointment/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointment(@PathVariable Integer doctorId){
        List<Appointment> appointment = appointmentServiceIMPL.getAppointment(doctorId);
        if(appointment!=null){
            return ResponseEntity.status(HttpStatus.OK).body(appointment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
