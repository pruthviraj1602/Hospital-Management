package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface billRepository extends JpaRepository<Bill,Integer> {

    public Bill getBillByBillId(Integer billId);

    public List<Bill> getBillByBillDate(String billDate);
}
