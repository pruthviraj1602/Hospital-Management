package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doctor")
public class doctorController {


    @Autowired
    private userServiceIMPL userServiceIMPL;





    @PostMapping("/save-doctor")
    public ResponseEntity<Doctor> saveUser(@RequestBody Doctor doctor){
        doctor.setRole("DOCTOR");
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
}
