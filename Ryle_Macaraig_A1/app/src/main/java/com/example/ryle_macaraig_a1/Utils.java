package com.example.ryle_macaraig_a1;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-11.
 */
public class Utils {

    //VALID EMAIL ADDRESS
    public static boolean isValidEmail(String email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    //VALID PHONE NUMBER
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            return Patterns.PHONE.matcher(phoneNumber).matches();
        }
        return false;
    }

    //VALID NAME
    public static boolean isValidName(String name) {

        String valid = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(valid, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

}
