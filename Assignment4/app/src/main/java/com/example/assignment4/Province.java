package com.example.assignment4;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-07-06.
 */
public class Province {
    //used to call name, capital, and image
    String name;
    String capital;
    int amId;

    //constructor for name, capital, and image
    public Province(String name, String capital, int amId) {
        this.name = name;
        this.capital = "Capital: " + capital;
        this.amId = amId;
    }

    //get methods for name, capital and image
    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getAmId() {
        return amId;
    }
}
