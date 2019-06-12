package com.jk.mvc;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-10.
 */
public class Utils {
    //if email is valid
    public static boolean isValidEmail (String target){
        //is not empty
        //text utils class that performs string data
        //if given variable is empty
        return (!TextUtils.isEmpty(target) &&
                Patterns.EMAIL_ADDRESS.matcher(target).matches());


        //valid first name - first letter must be letter
        //phone number min. 10 digits no letters
    }
}
