package com.jk.billcalc;

import com.jk.billcalc.model.Bill;

import java.util.ArrayList;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-19.
 */

//Singleton
public class BillSingleton {

    //lazy initialization, did not declare object yet
    private static BillSingleton billSingleton;

    //list of bill/empty list
    private ArrayList<Bill> billlist;

    //method with same name as class to initialize Array list
    //only once when the very first object of the class is created
    private BillSingleton(){
        billlist = new ArrayList<Bill>();
    }

    //one method accessible to anyone
    public static BillSingleton getInstance(){

        //if memory is allocated/empty, otherwise return what you have
        if (billSingleton == null){
            billSingleton = new BillSingleton();
        }
        return billSingleton;
    }

    //method to add new bill into ArrayList
    public void addBill (Bill newFeedback){
        billlist.add(newFeedback);
    }

    public Bill getBillByAccNumber(String acctNumber){

        for (Bill currentBill: billlist){
            //checking if the current bill object is same as we are searching
            if (currentBill.getAccountNumber().equals(acctNumber)){
                //account found and returning object


                return currentBill;
            }
        }
        //account does not exist
        return null;
    }


    public Bill getBill(String accountNumber) {

        for (Bill currentBill: billlist){
            //checking if the current bill object is
            //same as we are searching
            if (currentBill.getAccountNumber().equals(accountNumber)){
                //user account found and returning object
                return currentBill;
            }
        }
        //account does not exist
        return null;

    }
}
