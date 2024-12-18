package com.hospitalManagment.Services.IMPL;

import com.hospitalManagment.Entities.medicalRecord;
import com.hospitalManagment.Repositories.medicalRecordRepository;
import com.hospitalManagment.Services.medicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class medicalRecordServiceIMPL implements medicalRecordService {


    @Autowired
    private medicalRecordRepository medicalRecordRepository;

    @Override
    public medicalRecord saveRecords(medicalRecord record) {
        record.setDate(LocalDate.now().toString());
        return medicalRecordRepository.save(record);
    }
}
