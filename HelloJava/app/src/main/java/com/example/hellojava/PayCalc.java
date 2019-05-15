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
