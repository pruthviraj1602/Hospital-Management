package com.hospitalManagment.Services;

import com.hospitalManagment.Entities.medicalRecord;

import java.util.List;

public interface medicalRecordService {

    public medicalRecord saveRecords(medicalRecord record);

    public List<medicalRecord> getMedicalRecords();
}
