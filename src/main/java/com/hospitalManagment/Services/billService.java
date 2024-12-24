package com.hospitalManagment.Services;

import com.hospitalManagment.Entities.Bill;

import java.util.List;

public interface billService {

    public Bill saveBill(Bill bill);

    public List<Bill> getBills();

    public Bill getBill(Integer billId);

    public List<Bill> getBillByDate(String billDate);
}
