package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.*;
import com.hospitalManagment.Services.IMPL.appointmentServiceIMPL;
import com.hospitalManagment.Services.IMPL.billServiceIMPL;
import com.hospitalManagment.Services.IMPL.medicalRecordServiceIMPL;
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

    @Autowired
    private appointmentServiceIMPL appointmentServiceIMPL;

    @Autowired
    private medicalRecordServiceIMPL medicalRecordServiceIMPL;

    @Autowired
    private billServiceIMPL billServiceIMPL;


    @PostConstruct
    public void saveAdmin(){

        User user=new User();
        user.setUserId(1);
        user.setUserEmail("admin12@gmail.com");
        user.setUserPassword("12345");
        user.setRole("ROLE_ADMIN");

        userServiceIMPL.SaveUser(user);
    }


    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUser(){
        List<User> users = userServiceIMPL.getUsers();
        if(users!=null){
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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

        Patient patient1 = userServiceIMPL.savePatient(patient);
        if(patient1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(patient1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("update-doctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){

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


    @GetMapping("/getAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = appointmentServiceIMPL.getAppointments();
        if(appointments!=null){
            return ResponseEntity.status(HttpStatus.OK).body(appointments);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getMedicalRecords")
    public ResponseEntity<List<medicalRecord>> medicalRecords(){
        List<medicalRecord> medicalRecords = medicalRecordServiceIMPL.getMedicalRecords();
        if(medicalRecords!=null){
            return ResponseEntity.status(HttpStatus.OK).body(medicalRecords);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getScheduleAppointment")
    public ResponseEntity<List<scheduleAppointment>> getAllSchedule(){
        List<scheduleAppointment> scheduleAppointment = appointmentServiceIMPL.getScheduleAppointment();
        if(scheduleAppointment!=null){
            return ResponseEntity.status(HttpStatus.OK).body(scheduleAppointment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("getBills")
    public ResponseEntity<List<Bill>> getBills(){
        List<Bill> bills = billServiceIMPL.getBills();
        if(bills!=null){
            return ResponseEntity.status(HttpStatus.OK).body(bills);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("getBill/{billId}")
    public ResponseEntity<Bill> getBill(@PathVariable Integer billId){
        Bill bill = billServiceIMPL.getBill(billId);
        if(bill!=null){
            return ResponseEntity.status(HttpStatus.OK).body(bill);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @GetMapping("getBillsByDate/{billDate}")
    public ResponseEntity<List<Bill>> getBillsByDate(@PathVariable String billDate){
        List<Bill> billByDate = billServiceIMPL.getBillByDate(billDate);
        if(billByDate!=null){
            return ResponseEntity.status(HttpStatus.OK).body(billByDate);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }



}
