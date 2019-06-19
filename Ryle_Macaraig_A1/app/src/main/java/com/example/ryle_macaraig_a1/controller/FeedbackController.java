package com.example.ryle_macaraig_a1.controller;

import com.example.ryle_macaraig_a1.FeedbackSingleton;
import com.example.ryle_macaraig_a1.model.Feedback;

import java.util.ArrayList;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-06-12.
 */

//controller
//insertFeedback() method used to add the given feedback to the list of existing feedbacks
public class FeedbackController {

    public void insertFeedback(Feedback newFeedback){

        FeedbackSingleton.getInstance().addFeedback(newFeedback);
    }

    //get email
    public Feedback fetchFeedbackByEmail(String email){
        return FeedbackSingleton.getInstance().getFeedbackByEmail(email);
    }

}
