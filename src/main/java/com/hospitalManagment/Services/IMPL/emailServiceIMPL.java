package com.hospitalManagment.Services.IMPL;

import com.hospitalManagment.Services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailServiceIMPL implements emailService {


    @Autowired
    JavaMailSender mailSender;

    final static String FROM="pruthviraj7191@gmail.com";

    @Override
    public void sendEmail(String to, String message, String subject) {

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(FROM);
        mailSender.send(simpleMailMessage);

    }
}
