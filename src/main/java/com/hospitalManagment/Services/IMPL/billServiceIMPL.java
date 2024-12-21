package com.hospitalManagment.Services.IMPL;

import com.hospitalManagment.Entities.Bill;
import com.hospitalManagment.Repositories.billRepository;
import com.hospitalManagment.Services.billService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class billServiceIMPL implements billService {


    @Autowired
    private billRepository billRepository;

    @Override
    public Bill saveBill(Bill bill) {
        bill.setBillDate(LocalDate.now().toString());
        bill.setBillTime(LocalTime.now().toString());
        return billRepository.save(bill);
    }
}