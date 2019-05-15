package com.example.hellojava;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-15.
 */
public class Employee extends Person {
    double pay;

    Employee(){
        this.pay = 14;
    }

    Employee(double pay, String fnm, String lnm, int age){
        super(fnm, lnm, age);
        this.pay= pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    //override for to string method to get the functionality of the parent
    @Override
    public String toString() {
        return super.toString() + "\nPay: " + this.pay;
    }
}
