package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.medicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medicalRecordRepository extends JpaRepository<medicalRecord,Integer> {
}
