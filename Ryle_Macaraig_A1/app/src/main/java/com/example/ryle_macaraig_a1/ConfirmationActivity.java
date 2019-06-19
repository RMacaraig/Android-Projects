package com.example.ryle_macaraig_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ryle_macaraig_a1.controller.FeedbackController;
import com.example.ryle_macaraig_a1.model.Feedback;

public class ConfirmationActivity extends AppCompatActivity implements View.OnClickListener {

    //global variables
    Button btnDone;

    TextView tvRecommendation,
            tvHobbies,
            tvNewsletter,
            tvName,
            tvEmail,
            tvNumber,
            tvScore;

    FeedbackController feedbackController;

//    String recommendation, hobbies, newsletterYes, nameUser, number;
//    Integer creditScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        this.referWidgets(); //refer to UI views
        feedbackController = new FeedbackController(); //feedback controller
        this.fetchFeedbackInfo(); //get info from previous screen

    }

    private void referWidgets() {

        //text views
        tvRecommendation = findViewById(R.id.tv_recommendation);
        tvHobbies = findViewById(R.id.tv_hobbies);
        tvNewsletter = findViewById(R.id.tv_newsletter);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvNumber = findViewById(R.id.tv_number);
        tvScore = findViewById(R.id.tv_score);

        //calling button
        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);

    }

    //display all user info to text view
    private void fetchFeedbackInfo() {
        Intent thisIntent = this.getIntent();
        String email = thisIntent.getStringExtra("EXTRA_EMAIL");

//        Feedback currentFeedback = feedbackController.fetchFeedbackByEmail(email);
//        tvEmail.setText(currentFeedback.toString());

        Feedback currentFeedback = feedbackController.fetchFeedbackByEmail(email);
        tvEmail.setText(email);

        if (currentFeedback != null) {

            String recommendation = currentFeedback.getRecommendation();
            tvRecommendation.setText(recommendation);

            String hobbies = currentFeedback.getHobbies();
            tvHobbies.setText(hobbies);

            String newsletterYes = currentFeedback.getFrequency();
            tvNewsletter.setText(newsletterYes);

            String nameUser = currentFeedback.getName();
            tvName.setText(nameUser);

            String number = currentFeedback.getPhoneNumber();
            tvNumber.setText(number);

            Integer creditScore = currentFeedback.getCreditScore();
            tvScore.setText(creditScore.toString());

//            Double amount = currentFeedback.getAmount;
//            tvAmount.setText(amount.toString());
        }

    }

    //method used when button is clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                this.finishAffinity(); //stop activity from running -hidden and terminated
                break;
        }
    }

}
