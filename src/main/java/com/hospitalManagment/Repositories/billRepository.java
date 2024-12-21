package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface billRepository extends JpaRepository<Bill,Integer> {
}
