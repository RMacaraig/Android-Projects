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

    // global variables initialized
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoSelected; //radio buttons-only 1 radio button is selected

    RadioButton rdoYes, rdoNo, rdoMaybe;

    Spinner spnNewsletter;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;

    String newsletter = "";
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

        //initialize radio button yes when clicked and call spinner selected with credit score
        String frequency = "";
        if (rdoYes.isChecked()) {
            recommendation = getResources().getString(R.string.yes);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore += 20;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore += 15;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore += 10;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
                creditScore += 0;
            }

            //initialize radio button no when clicked and call spinner selected with credit score
        } else if (rdoNo.isChecked()) {
            recommendation = getResources().getString(R.string.no);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore += 05;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore += 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore += 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
                creditScore += 0;

            }

            //initialize radio button maybe when clicked and call spinner selected with credit score
        } else if (rdoMaybe.isChecked()) {

            recommendation = getResources().getString(R.string.maybe);

            if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.daily))) {

                frequency = getResources().getString(R.string.daily);
                creditScore += 05;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.weekly))) {

                frequency = getResources().getString(R.string.weekly);
                creditScore += 02;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.monthly))) {

                frequency = getResources().getString(R.string.monthly);
                creditScore += 0;

            } else if (spnNewsletter.getSelectedItem().equals(getResources().getString(R.string.never))) {

                frequency = getResources().getString(R.string.never);
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

        //calling all variables
        hobbies = selectedHobbies;
        newsletter = frequency;
        nameUser = name;
        emailUser = email;
        number = phone;
    }

    //method used to open next activity to transfer user information
    private void openNextActivity() {

        Intent confirmationIntent = new Intent(this, ConfirmationActivity.class);

        confirmationIntent.putExtra("EXTRA_RECOMMENDATION", recommendation);
        confirmationIntent.putExtra("EXTRA_HOBBIES", hobbies);
        confirmationIntent.putExtra("EXTRA_NEWSLETTER", newsletter);
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
