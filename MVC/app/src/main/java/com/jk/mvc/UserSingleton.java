package com.jk.mvc;

import android.util.Log;
import com.jk.mvc.model.User;
import java.util.ArrayList;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-12.
 */

//data
    //get instance of class
public class UserSingleton {

    //lazy initialization
    //did not declare object yet
    private static UserSingleton userSingleton;

    //list of users
    //empty list
    private ArrayList<User> userlist;

    //method with same name as class to initialize Array list
    //only once when the very first object of the class is created
    private UserSingleton(){
        userlist = new ArrayList<User>();
    }



    //one method accessible to anyone
    public static UserSingleton getInstance(){

        //if memory is allocated, otherwise return what you have
        if (userSingleton == null){
            userSingleton = new UserSingleton();
        }
        return userSingleton;
    }

    //method to add new user into ArrayList
    public void addUser (User newUser){
        userlist.add(newUser);

        Log.d("UserSingleton", "New user added \n " + newUser.toString());

    }

    public User getUserByEmail(String email){

        for (User currentUser: userlist){
            //checking if the current user object is
            //same as we are searching
            if (currentUser.getEmail().equals(email)){
                //user account found and returning object
                return currentUser;
            }
        }
        //account does not exist
        return null;
    }





    //
    public ArrayList<User> getUserList(){
        return userlist;

    }

    public boolean validateUser(String email, String password){
        for (User currentUser : userlist){
            //check if email and password are valid
            if (currentUser.getEmail().equals(email) &&
            currentUser.getPassword().equals(password)){
                //user found and is valid
                return true;
            }
        }

        //user is not found or invalid
        return false;
    }

}
