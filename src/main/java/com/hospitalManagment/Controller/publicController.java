package com.hospitalManagment.Controller;

import com.hospitalManagment.Configuration.customUserDetailIMPL;
import com.hospitalManagment.Entities.Doctor;
import com.hospitalManagment.Entities.User;
import com.hospitalManagment.Entities.loginRequest;
import com.hospitalManagment.JWT.jwtUtils;
import com.hospitalManagment.Repositories.userRepository;
import com.hospitalManagment.Services.IMPL.userServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class publicController {


    @Autowired
    private userServiceIMPL userServiceIMPL;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private customUserDetailIMPL customUserDetailIMPL;
    
    @Autowired
    private userRepository userRepository;

    @Autowired
    private jwtUtils jwtUtils;


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

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody loginRequest request){

        Authentication authenticate;
        try {
          authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserEmail(), request.getUserPassword()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("invalid Credentials");
        }


        UserDetails userDetails = customUserDetailIMPL.loadUserByUsername(request.getUserEmail());
        User user = userRepository.getUserByUserEmail(request.getUserEmail());

        String jwt = null;

        if(authenticate.isAuthenticated()){
          jwt=jwtUtils.generateToken(userDetails.getUsername());
        }

        if (jwt != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jwt);
        }
        return null;

    }
}
