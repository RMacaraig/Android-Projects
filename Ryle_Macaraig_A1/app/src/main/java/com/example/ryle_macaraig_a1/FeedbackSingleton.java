package com.example.ryle_macaraig_a1;

import com.example.ryle_macaraig_a1.model.Feedback;

import java.util.ArrayList;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-11.
 */

//an ArrayList to hold all the Feedback objects
//getFeedbackByEmail() method which will return Feedback
// object associated with given email
//addFeedback() method to insert a new Feedback object into the ArrayList.

public class FeedbackSingleton {

    //lazy initialization, did not declare object yet
    private static FeedbackSingleton feedbackSingleton;

    //list of feedback/empty list
    private ArrayList<Feedback> feedbacklist;

    //method with same name as class to initialize Array list
    //only once when the very first object of the class is created
    private FeedbackSingleton(){
        feedbacklist = new ArrayList<Feedback>();
    }

    //one method accessible to anyone
    public static FeedbackSingleton getInstance(){

        //if memory is allocated/empty, otherwise return what you have
        if (feedbackSingleton == null){
            feedbackSingleton = new FeedbackSingleton();
        }
        return feedbackSingleton;
    }

    //method to add new feedback into ArrayList
    public void addFeedback (Feedback newFeedback){
        feedbacklist.add(newFeedback);
    }

    public Feedback getFeedbackByEmail(String email){

        for (Feedback currentFeedback: feedbacklist){
            //checking if the current feedback object is same as we are searching
            if (currentFeedback.getEmail().equals(email)){
                //feedback account found and returning object
                return currentFeedback;
            }
        }
        //account does not exist
        return null;
    }
}
