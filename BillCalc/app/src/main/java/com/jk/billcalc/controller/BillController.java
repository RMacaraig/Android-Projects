package com.jk.billcalc.controller;

import com.jk.billcalc.model.Bill;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-19.
 */

//controller
public class BillController {

    public void insertBill(Bill newBill){

        BillSingleton.getInstance().addBill(newBill);
    }

    //get account number
    public Bill fetchBillByAccNumber(String accountNumber){
        return BillSingleton.getInstance().getBill(accountNumber);
    }
}
