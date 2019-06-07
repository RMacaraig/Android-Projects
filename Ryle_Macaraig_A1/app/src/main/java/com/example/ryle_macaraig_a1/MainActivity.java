package com.example.ryle_macaraig_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-28.
 */

//implements View.OnClickListener is used to call submit and cancel buttons
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //class global variables initialized
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoSelected; //radio buttons-only 1 radio button is selected

    RadioButton rdoYes, rdoNo, rdoMaybe;

    Spinner spnNewsletter;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;

    String newsletterYes = "";
    String newsletterNo = "";
    String newsletterMaybe = "";

    String recommendation = "";
    String hobbies = "";
    String nameUser = "";
    String emailUser = "";
    String number = "";

    Integer creditScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI views
        this.referWidgets();
    }

    //method used to call UI views
    private void referWidgets() {

        //EditTexts
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);

        //RadioGroup
        rdoApp = findViewById(R.id.rdo_app);

        //RadioButton
        rdoYes = findViewById(R.id.rdo_yes);
        rdoNo = findViewById(R.id.rdo_no);
        rdoMaybe = findViewById(R.id.rdo_maybe);


        //Checkboxes
        chkGuitar = findViewById(R.id.chk_guitar);
        chkFootball = findViewById(R.id.chk_football);
        chkSinging = findViewById(R.id.chk_singing);
        chkChess = findViewById(R.id.chk_chess);
        chkHorseRiding = findViewById(R.id.chk_horse_riding);
        chkReading = findViewById(R.id.chk_reading);

        //Spinner
        spnNewsletter = findViewById(R.id.spn_newsletter);

        //calling string array from spinner
        //creating object of array adapter class for the character sequence type
        //createFromResource is used to create object and specify context of current activity
        ArrayAdapter<CharSequence> dayAdapter =
                ArrayAdapter.createFromResource(this, R.array.newsletter_array_eng,
                        android.R.layout.simple_spinner_dropdown_item);

        //calling spinner array
        spnNewsletter.setAdapter(dayAdapter);

        //submit button on click
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        //cancel button on click
        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);

    }

    //onClick method used when submit and cancel buttons are clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel: //cancel button
                this.finishAffinity(); //method used to terminate app
                break;

            case R.id.btn_submit: //submit button
                this.getValues(); //method used to get values
                this.openNextActivity(); //create method to open next activity
                this.errorCheck(); //method used for error checking
                break;
        }

    }

    //get values method used when submit button is clicked
    private void getValues() {

        //retrieve name, email, and phone of user
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();

        //getting a radio button that is selected
        rdoSelected = findViewById(rdoApp.getCheckedRadioButtonId());
        //String app = rdoSelected.getText().toString();

        String app = "";
        String newsYes = "";
        if (rdoYes.isChecked()) {

            app = rdoYes.getResources().getString(R.string.yes);

            if (spnNewsletter.getSelectedItem().equals("Daily")) {

                newsYes += getResources().getString(R.string.daily);
                creditScore += 20;
            }

            if (spnNewsletter.getSelectedItem().equals("Weekly")) {

                newsYes += getResources().getString(R.string.weekly);
                creditScore += 15;
            }

            if (spnNewsletter.getSelectedItem().equals("Monthly")) {

                newsYes += getResources().getString(R.string.monthly);
                creditScore += 10;
            }
            if (spnNewsletter.getSelectedItem().equals("Never")) {

                newsYes += getResources().getString(R.string.never);
                creditScore += 0;
            }

        }

        String newsNo = "";
        if (rdoNo.isChecked()) {

            app = rdoNo.getResources().getString(R.string.no);

            if (spnNewsletter.getSelectedItem().equals("Daily")) {
                newsNo += getResources().getString(R.string.daily);
                creditScore += 05;
            }

            if (spnNewsletter.getSelectedItem().equals("Weekly")) {
                newsNo += getResources().getString(R.string.weekly);
                creditScore += 0;
            }

            if (spnNewsletter.getSelectedItem().equals("Monthly")) {
                newsNo += getResources().getString(R.string.monthly);
                creditScore += 0;
            }
            if (spnNewsletter.getSelectedItem().equals("Never")) {
                newsNo += getResources().getString(R.string.never);
                creditScore += 0;
            }

        }

        String newsMaybe = "";
        if (rdoMaybe.isChecked()) {

            app = rdoMaybe.getResources().getString(R.string.maybe);

            if (spnNewsletter.getSelectedItem().equals("Daily")) {
                newsMaybe += getResources().getString(R.string.daily);
                creditScore += 05;
            }

            if (spnNewsletter.getSelectedItem().equals("Weekly")) {
                newsMaybe += getResources().getString(R.string.weekly);
                creditScore += 02;
            }

            if (spnNewsletter.getSelectedItem().equals("Monthly")) {
                newsMaybe += getResources().getString(R.string.monthly);
                creditScore += 0;
            }
            if (spnNewsletter.getSelectedItem().equals("Never")) {
                newsMaybe += getResources().getString(R.string.never);
                creditScore += 0;
            }

        }

        //check box functionality when clicked
        //users can have multiple check boxes clicked
        String selectedHobbies = "";
        if (chkGuitar.isChecked()) {

            selectedHobbies += getResources().getString(R.string.guitar);
            selectedHobbies = selectedHobbies + "\n";

        }
        if (chkFootball.isChecked()) {

            selectedHobbies += getResources().getString(R.string.football);
            selectedHobbies = selectedHobbies + "\n";
        }
        if (chkSinging.isChecked()) {

            selectedHobbies += getResources().getString(R.string.singing);
            selectedHobbies = selectedHobbies + "\n";
        }
        if (chkChess.isChecked()) {

            selectedHobbies += getResources().getString(R.string.chess);
            selectedHobbies = selectedHobbies + "\n";

        }
        if (chkHorseRiding.isChecked()) {

            selectedHobbies += getResources().getString(R.string.horse_riding);
            selectedHobbies = selectedHobbies + "\n";

        }
        if (chkReading.isChecked()) {

            selectedHobbies += getResources().getString(R.string.reading);
            selectedHobbies = selectedHobbies + "\n";

        }

        //get spinner output
        //String newsletter = spnNewsletter.getSelectedItem().toString();
        recommendation = app;
        hobbies = selectedHobbies;
        newsletterYes = newsYes;
        newsletterNo = newsNo;
        newsletterMaybe = newsMaybe;
        nameUser = name;
        emailUser = email;
        number = phone;
    }

    private void openNextActivity() {

        Intent confirmationIntent = new Intent(this, ConfirmationActivity.class);

        confirmationIntent.putExtra("EXTRA_RECOMMENDATION", recommendation);
        confirmationIntent.putExtra("EXTRA_HOBBIES", hobbies);

        confirmationIntent.putExtra("EXTRA_NEWSLETTER_YES", newsletterYes);
        confirmationIntent.putExtra("EXTRA_NEWSLETTER_NO", newsletterNo);
        confirmationIntent.putExtra("EXTRA_NEWSLETTER_MAYBE", newsletterMaybe);

        confirmationIntent.putExtra("EXTRA_NAME", nameUser);
        confirmationIntent.putExtra("EXTRA_EMAIL", emailUser);
        confirmationIntent.putExtra("EXTRA_NUMBER", number);

        confirmationIntent.putExtra("EXTRA_CREDIT_SCORE", creditScore);
        startActivity(confirmationIntent);
    }

    //error check if users does not input name, email, or phone number
    //(added this method for fun)
    private boolean errorCheck() {

        //editText name when input is empty
        if (edtName.length() == 0) {
            edtName.setError("Name is required");
        }

        //editText email when input is empty
        if (edtEmail.length() == 0) {
            edtEmail.setError("Email is required");
        }

        //editText phone when input is empty
        if (edtPhone.length() == 0) {
            edtPhone.setError("Phone number is required");
        }
        return true;
    }

}
