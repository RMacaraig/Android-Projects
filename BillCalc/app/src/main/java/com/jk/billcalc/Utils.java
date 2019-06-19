package com.jk.billcalc;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-19.
 */
public class Utils {

    //VALID Account Number
    public static boolean isValidAccountNumber(String account) {
        // ^ beginning of string
        // [a-zA-Z ] search for letters
        // + string has at least one letter
        // $ end of string
        String number = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(number, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(account);
        return matcher.find();
    }

    //VALID NAME
    public static boolean isValidName(String name) {
        // ^ beginning of string
        // [a-zA-Z ] search for letters
        // + string has at least one letter
        // $ end of string
        String user = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(user, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    //VALID Weekday
    public static boolean isValidWeekday(String weekday) {
        if (!TextUtils.isEmpty(weekday)) {
            return Patterns.PHONE.matcher(weekday).matches();
        }
        return false;
    }

    //VALID Weekday
    public static boolean isValidEvening(String evening) {
        if (!TextUtils.isEmpty(evening)) {
            return Patterns.PHONE.matcher(evening).matches();
        }
        return false;
    }

    //VALID Weekday
    public static boolean isValidVideo(String video) {
        if (!TextUtils.isEmpty(video)) {
            return Patterns.PHONE.matcher(video).matches();
        }
        return false;
    }

}
