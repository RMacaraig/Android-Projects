package com.example.ryle_macaraig_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        this.referWidgets(); //refer to UI views
        this.fetchExtras(); //get info from previous screen

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


    private void fetchExtras() {

        //calling current intent class
        Intent currentIntent = this.getIntent();

        String recommendation = currentIntent.getStringExtra("EXTRA_RECOMMENDATION"); //retrieve the string used
        tvRecommendation.setText(recommendation);

        String hobbies = currentIntent.getStringExtra("EXTRA_HOBBIES"); //retrieve the string used
        tvHobbies.setText(hobbies);

        String newsletterFreq= currentIntent.getStringExtra("EXTRA_NEWSLETTER"); //retrieve the string used
        tvNewsletter.setText(newsletterFreq);

        String nameUser = currentIntent.getStringExtra("EXTRA_NAME"); //retrieve the string used
        tvName.setText(nameUser);

        String emailUser = currentIntent.getStringExtra("EXTRA_EMAIL"); //retrieve the string used
        tvEmail.setText(emailUser);

        String number = currentIntent.getStringExtra("EXTRA_NUMBER"); //retrieve the string used
        tvNumber.setText(number);

        Double yesScore = currentIntent.getDoubleExtra("EXTRA_YES_SCORE",0.0);
        tvScore.setText(yesScore.toString());

        Double noScore = currentIntent.getDoubleExtra("EXTRA_NO_SCORE",0.0);
        tvScore.setText(noScore.toString());

        Double maybeScore = currentIntent.getDoubleExtra("EXTRA_MAYBE_SCORE",0.0);
        tvScore.setText(maybeScore.toString());

    }


    //method used when button is clicked
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_done:
                this.finishAffinity(); //stop activity from running -hidden and terminated
                break;
        }
    }




}
