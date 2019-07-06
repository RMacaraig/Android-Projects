package com.example.bmi;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-07-05.
 */
public class BMI {
    double height;
    double weight;

    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getBmi() {

        double bmi = weight/Math.pow(height, 2);

        return bmi;

    }

    @Override
    public String toString() {

        String format = "This person is %.1fm tall," +
                " weighs %.1fkg and has a BMI of %.1f";

        return String.format(format, height, weight, getBmi());

    }
}

