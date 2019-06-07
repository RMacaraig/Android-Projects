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

        String hobbies = currentIntent.getStringExtra("EXTRA_HOBBIES");
        tvHobbies.setText(hobbies);

        String newsletterYes = currentIntent.getStringExtra("EXTRA_NEWSLETTER_YES");
        tvNewsletter.setText(newsletterYes);

        String newsletterNo = currentIntent.getStringExtra("EXTRA_NEWSLETTER_NO");
        tvNewsletter.setText(newsletterNo);

        String newsletterMaybe = currentIntent.getStringExtra("EXTRA_NEWSLETTER_MAYBE");
        tvNewsletter.setText(newsletterMaybe);

        String nameUser = currentIntent.getStringExtra("EXTRA_NAME");
        tvName.setText(nameUser);

        String emailUser = currentIntent.getStringExtra("EXTRA_EMAIL");
        tvEmail.setText(emailUser);

        String number = currentIntent.getStringExtra("EXTRA_NUMBER");
        tvNumber.setText(number);

        Integer creditScore = currentIntent.getIntExtra("EXTRA_CREDIT_SCORE", 0);
        tvScore.setText(creditScore.toString());

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
