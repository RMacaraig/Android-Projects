package com.example.hellojava;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-15.
 */

/*
Experiment:
Add type of employee (full-time or part-time)
Add data member to indicate the basic pay of employee
(basic pay for part-time is $20, full-time is $50)
add a variable to represent the number of hours employee has worked

add a method to calculate the final pay for
the employee considering the number of hours they
have worked and their status
 */

public class Employee extends Person {
    double pay;
    double partTime;
    double fullTime;

    Employee(){
        this.pay = 14;
        partTime = 20;
        fullTime = 50;
    }

    Employee(double pay, double partTime, double fullTime, String fnm, String lnm, int age){
        super(fnm, lnm, age);
        this.pay= pay;
        this.partTime = partTime;
        this.fullTime = fullTime;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    //set and get for part-time
    public void setPartTime(double partTime) {
        this.partTime = partTime;
    }

    public double getPartTime() {
        return partTime;
    }

    //set and get for full-time
    public void setFullTime(double fullTime) {
        this.fullTime = fullTime;
    }

    public double getFullTime() {
        return fullTime;
    }

    //override for to string method to get the functionality of the parent
    @Override
    public String toString() {
        String data = "\nPart-time: " + this.partTime;
        data += "\nFull-time: " + this.fullTime;
        data += "\nPay: " + this.pay;

        return data;
        //return super.toString() + "\nPay: " + this.pay;

    }
}
