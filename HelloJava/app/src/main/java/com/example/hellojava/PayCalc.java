package com.example.hellojava;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-15.
 */
public class PayCalc {
    //method to execute java class
    //getting all attributes
    public static void main(String []args){
        //default constructor
        Person me = new Person();
        me.setFirstName("RM");
        me.setLastName("LM");
        me.setAge(90);
        System.out.println(me.toString());

        Person you = new Person("Faaiz", "Rehan", 22);
        System.out.println(you.toString());

        Employee prof = new Employee();
        prof.setFirstName("Adem");
        prof.setLastName("Eve");
        prof.setAge(50);
        prof.setPay(20.50);
        System.out.println(prof.toString());

    }
}




//public class simpleCalc {
//
//    double add(){
//        return 0;
//    }
//
//    double mult(){
//        return 0;
//    }
//
//    double exp(){
//        return 0;
//    }
//
//    simpleCalc(){
//
//    };

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
