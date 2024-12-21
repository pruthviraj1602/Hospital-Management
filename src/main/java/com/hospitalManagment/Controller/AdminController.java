package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.Patient;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private userServiceIMPL userServiceIMPL;



    @PostConstruct
    public void saveAdmin(){
        Patient patient=new Patient();
        patient.setPatientId(1);
        patient.setPatientName("ADMIN");
        patient.setPatientEmail("admin12@gmail.com");
        patient.setPatientPassword("123456");
        patient.setPatientContact("9898989898");
        patient.setRole("ADMIN");

        userServiceIMPL.savePatient(patient);
    }


    @GetMapping("/getDoctors")
    public ResponseEntity<List<Doctor>> getDoctors(){
        List<Doctor> allDoctors = userServiceIMPL.getAllDoctors();
        if(allDoctors!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allDoctors);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getPatients")
    public ResponseEntity<List<Patient>> getPatient(){
        List<Patient> allUser = userServiceIMPL.getAllUser();
        if(allUser!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/update-patient")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        patient.setRole("PATIENT");
        Patient patient1 = userServiceIMPL.savePatient(patient);
        if(patient1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(patient1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("update-doctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
        doctor.setRole("DOCTOR");
        Doctor doctor1 = userServiceIMPL.saveDoctor(doctor);
        if(doctor1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(doctor1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId){
        Integer i = userServiceIMPL.deletePatient(patientId);
        if(i!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Patient Deleted ");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient Not Deleted ");
    }

    @DeleteMapping("/deleteDoctor/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Integer doctorId){
        Integer i = userServiceIMPL.deleteDoctor(doctorId);
        if(i!=null){
            return ResponseEntity.status(HttpStatus.OK).body("Doctor Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Doctor Not Deleted");
    }


//    @GetMapping("/getAppointments")

}
