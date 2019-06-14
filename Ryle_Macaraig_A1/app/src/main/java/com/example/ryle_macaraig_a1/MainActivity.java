package com.example.ryle_macaraig_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.ryle_macaraig_a1.controller.FeedbackController;
import com.example.ryle_macaraig_a1.model.Feedback;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-28.
 */

//implements View.OnClickListener is used to call submit and cancel buttons
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // global variables initialized
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoSelected; //radio buttons-only 1 radio button is selected
    RadioButton rdoYes, rdoNo, rdoMaybe;

    Spinner spnNewsletter;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;
    String nameUser, emailUser, number, newsletter, selectedHobbies;

    String recommendation, hobbies, frequency, name, email, phoneNumber;
    Integer creditScore = 0;

    Feedback newFeedback;
    FeedbackController feedbackController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI views
        this.referWidgets();
        feedbackController = new FeedbackController();
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
                ArrayAdapter.createFromResource(this, R.array.newsletter_array,
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
                if (this.validateData()) {
                    this.getValues();

                    newFeedback = new Feedback(recommendation, hobbies, frequency, name, email, phoneNumber, creditScore);
                    feedbackController.insertFeedback(newFeedback);

                    Intent confirmationIntent = new Intent(this, ConfirmationActivity.class);
                    confirmationIntent.putExtra("EXTRA_EMAIL", email);
                    startActivity(confirmationIntent);
                }
                break;
        }
    }

    //get values method used when submit button is clicked
    private void getValues() {

        //retrieve name, email, and phone of user
        name = edtName.getText().toString();
        email = edtEmail.getText().toString();
        phoneNumber = edtPhone.getText().toString();

        //getting a radio button that is selected
        rdoSelected = findViewById(rdoApp.getCheckedRadioButtonId());
        recommendation = rdoSelected.getText().toString();

        //spinner selected


        //initialize radio button yes when clicked and call spinner selected with credit score
         frequency = "";
        if (rdoYes.isChecked()) {
            recommendation = getResources().getString(R.string.yes);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore = 20;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore = 15;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore = 10;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
                creditScore = 0;
            }

            //initialize radio button no when clicked and call spinner selected with credit score
        } else if (rdoNo.isChecked()) {
            recommendation = getResources().getString(R.string.no);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore = 05;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore = 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore = 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
                creditScore = 0;

            }

            //initialize radio button maybe when clicked and call spinner selected with credit score
        } else if (rdoMaybe.isChecked()) {

            recommendation = getResources().getString(R.string.maybe);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore = 05;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore = 02;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore = 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
                creditScore = 0;

            }
        }

        //check box functionality when clicked
        //users can have multiple check boxes clicked
        selectedHobbies = "";
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

        //calling all variables
        hobbies = selectedHobbies;
        newsletter = frequency;
        nameUser = name;
        emailUser = email;
        number = phoneNumber;
    }

    //error check if users does not input name, email, or phone number
    private boolean validateData() {
        boolean allValidations = true;

        //NAME
        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("Name is required");
            allValidations = false;
        } else if (!Utils.isValidName(edtName.getText().toString())) {
            edtName.setError("Please provide valid name");
            allValidations = false;
        }

        //EMAIL
        if (edtEmail.getText().toString().isEmpty()) {
            edtEmail.setError("Email address is required");
            allValidations = false;
        } else if (!Utils.isValidEmail(edtEmail.getText().toString())) {
            edtEmail.setError("Please provide valid email address");
            allValidations = false;
        }

        //PHONE NUMBER
        if (edtPhone.getText().toString().isEmpty()) {
            edtPhone.setError("Phone number is required");
            allValidations = false;
        } else if (!Utils.isValidPhoneNumber(edtPhone.getText().toString())) {
            edtPhone.setError("Please provide valid phone number");
            allValidations = false;
        }
        return allValidations;
    }

}
