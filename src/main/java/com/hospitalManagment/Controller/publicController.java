package com.hospitalManagment.Controller;

import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.User;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class publicController {


    @Autowired
    private userServiceIMPL userServiceIMPL;


    @PostMapping("/save-nurse")
    public ResponseEntity<User> saveNurse(@RequestBody User user){
       user.setRole("ROLE_NURSE");

        User user1 = userServiceIMPL.SaveUser(user);
        if(user1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/save-patient")
    public ResponseEntity<User> savePatient(@RequestBody User user){
        user.setRole("ROLE_PATIENT");

        User user1 = userServiceIMPL.SaveUser(user);
        if(user1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/save-doctor")
    public ResponseEntity<User> saveDoctor(@RequestBody User user){
        user.setRole("ROLE_DOCTOR");

        User user1 = userServiceIMPL.SaveUser(user);
        if(user1!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
